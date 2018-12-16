package interpreter.constraint;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import other.House;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONConstraint {

    public static void decode_constraint(String json, House house){
        try {
            boolean res1 = decode_rooms(house);
            boolean res2 = decode_sensors(house);
            boolean res3 = decode_soft(house);


            Object o1 = new JSONParser().parse(new FileReader(json));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            JSONObject sensor = (JSONObject) jo.get("sensors");
            JSONObject rooms = (JSONObject) jo.get("rooms");
            JSONObject soft = (JSONObject) jo.get("software");

            if(res1){
                rooms.put("value",true);
            }
            else {
                rooms.put("value",false);
            }

            if(res2){
                sensor.put("value",true);
            }
            else {
                sensor.put("value",false);
            }

            if(res3){
                soft.put("value",true);
            }
            else {
                soft.put("value",false);
            }

            if(res1 && res2 && res3){
                jo.put("value",true);
            }
            else {
                jo.put("value",false);
            }

            try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/res/feature_model.json"))
            {
                file.write(j.toString());
            }

        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean decode_soft(House house){
        try {
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            JSONObject json = (JSONObject) jo.get("software");

            Expression_constraint constraint = new SofwareExpression();
            boolean management_heating = constraint.interpret("management_heating", json,house);
            boolean management_air_conditioning = constraint.interpret("management_air_conditioning", json,house);
            boolean management_light = constraint.interpret("management_light", json,house);
            boolean management_humidity = constraint.interpret("management_humidity", json,house);
            boolean management_hifi = constraint.interpret("management_hifi", json,house);
            boolean management_windows = constraint.interpret("management_windows", json,house);
            boolean management_tv = constraint.interpret("management_tv", json,house);
            boolean management_ventilation = constraint.interpret("management_ventilation", json,house);
            boolean management_shutter_window = constraint.interpret("management_shutter_window", json,house);
            return management_air_conditioning || management_heating || management_hifi || management_humidity || management_light || management_shutter_window ||management_ventilation || management_tv && management_windows;
        }
        catch (IOException | ParseException e){
            return false;
        }
    }

    public static boolean decode_constaint(List<String> lst, JSONObject json, House house){
        Expression_constraint constraint = new SensorExpression();
        boolean res = true;
        for (String str : lst) {
            res = res && constraint.interpret(str,json,house);
        }
        return res;
    }

    private static boolean decode_sensors(House house){
        try {
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            JSONObject json = (JSONObject) jo.get("sensors");

            Expression_constraint constraint = new SensorExpression();
            boolean humidity = constraint.interpret("humidity", json,house);
            boolean light = constraint.interpret("light", json,house);
            boolean temperature = constraint.interpret("temperature", json,house);
            boolean pollution = constraint.interpret("pollution", json,house);
            boolean wind = constraint.interpret("wind", json,house);
            boolean sonore = constraint.interpret("sonore", json,house);
            boolean movement = constraint.interpret("movement", json,house);
            boolean camera = constraint.interpret("camera", json,house);
            return humidity  || light || temperature || pollution || wind || sonore || movement || camera;
        }
        catch (IOException | ParseException e){
            return false;
        }
    }


    private static boolean decode_rooms(House house){
        try {
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            JSONObject json = (JSONObject) jo.get("rooms");

            Expression_constraint constraint = new RoomExpression();
            boolean garden = constraint.interpret("garden", json,house);
            boolean kitchen = constraint.interpret("kitchen", json,house);
            boolean living_room = constraint.interpret("living_room", json,house);
            boolean bedroom = constraint.interpret("bedroom", json,house);
            boolean bathroom = constraint.interpret("bathroom", json,house);
            boolean laundry_room = constraint.interpret("laundry_room", json,house);
            boolean entry = constraint.interpret("entry", json,house);
            boolean dinning_room = constraint.interpret("dinning_room", json,house);
            boolean game_room = constraint.interpret("game_room", json,house);
            return game_room && garden && kitchen && laundry_room && living_room && bedroom && bathroom && entry && dinning_room;
        }
        catch (IOException | ParseException e){
            return false;
        }
    }

    public static void modify_json(int category, String tag, boolean value){
        try {
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            if (category == 1) {
                JSONObject soft = (JSONObject) jo.get("software");
                JSONObject object = (JSONObject) soft.get(tag);

                JSONArray array = (JSONArray) object.get("constraint");
                List<String> res = new ArrayList<>();
                for(int i = 0; i < array.size(); i++){
                    res.add((String) array.get(i));
                }

                object.put("value",check_constraint(res));

                try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/res/feature_model.json"))
                {
                    file.write(j.toString());
                }
            } else if (category == 2) {
                if(!tag.contains("_")){
                    JSONObject sensor = (JSONObject) jo.get("sensors");
                    sensor.put(tag,value);
                    try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/res/feature_model.json"))
                    {
                        file.write(j.toString());
                    }
                }
            } else if (category == 3) {
                JSONObject rooms = (JSONObject) jo.get("rooms");
                JSONObject object = (JSONObject) rooms.get(tag);
                if((boolean) object.get("mandatory")){
                    object.put("value",value);
                    try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/res/feature_model.json"))
                    {
                        file.write(j.toString());
                    }
                }
            }
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public static boolean check_constraint(List<String> constraints){
        boolean res = true;
        for (String tag : constraints) {
            res = res && check_constraint2(tag);
        }
        return res;
    }

    public static boolean check_constraint2(String tag){
        try {
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            JSONObject sensor = (JSONObject) jo.get("sensors");
            if (sensor.get(tag) != null)
                return (boolean) sensor.get(tag);
            else
                return check_constraint3(tag);
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean check_constraint3(String tag){
        try {
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            JSONObject software = (JSONObject) jo.get("software");
            JSONObject j2 = (JSONObject) software.get(tag);
            return (boolean) j2.get("value");
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return false;
    }

}
