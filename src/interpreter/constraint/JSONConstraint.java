package interpreter.constraint;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import other.House;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JSONConstraint {

    public boolean decode_constraint(String json, House house){
        try {
            Object o1 = new JSONParser().parse(new FileReader(json));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            if((boolean) jo.get("value")) {
                JSONObject soft = (JSONObject) jo.get("software");
                JSONObject sensor = (JSONObject) jo.get("sensors");
                JSONObject rooms = (JSONObject) jo.get("rooms");
                return decode_rooms(rooms,house) && decode_sensors(sensor,house) && decode_soft(soft,house);
            }
            return true;
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean decode_soft(JSONObject json, House house){
        if((boolean) json.get("value")){
            Expression_constraint constraint = new SofwareExpression(true,"cool");
            boolean management_heating = constraint.interpret("management_heating", json,house);
            boolean management_air_conditioning = constraint.interpret("management_air_conditioning", json,house);
            boolean management_light = constraint.interpret("management_light", json,house);
            boolean management_humidity = constraint.interpret("management_humidity", json,house);
            boolean management_hifi = constraint.interpret("management_hifi", json,house);
            boolean management_tv = constraint.interpret("management_tv", json,house);
            boolean management_ventilation = constraint.interpret("management_ventilation", json,house);
            boolean management_shutter_window = constraint.interpret("management_shutter_window", json,house);
            return management_air_conditioning && management_heating && management_hifi && management_humidity && management_light && management_shutter_window && management_tv && management_ventilation;
        }
        return true;
    }

    public static boolean decode_constaint(List<String> lst, JSONObject json, House house){
        Expression_constraint constraint = new SensorExpression(true,"cool");
        boolean res = true;
        for (String str : lst) {
            res = res && constraint.interpret(str,json,house);
        }
        return res;
    }

    public boolean decode_sensors(JSONObject json, House house){
        Expression_constraint constraint = new SensorExpression(true,"cool");
        boolean value = constraint.interpret("value", json,house);
        boolean humidity = constraint.interpret("humidity", json,house);
        boolean light = constraint.interpret("light", json,house);
        boolean temperature = constraint.interpret("temperature", json,house);
        boolean pollution = constraint.interpret("pollution", json,house);
        boolean wind = constraint.interpret("wind", json,house);
        boolean sonore = constraint.interpret("sonore", json,house);
        boolean movement = constraint.interpret("movement", json,house);
        boolean camera = constraint.interpret("camera", json,house);
        return value && humidity && light && temperature && pollution && wind && sonore && movement && camera;
    }

    public boolean decode_rooms(JSONObject json, House house){
        if((boolean) json.get("value")){
            Expression_constraint constraint = new RoomExpression(true,"cool");
            boolean garden = constraint.interpret("garden", json,house);
            boolean kitchen = constraint.interpret("kitchen", json,house);
            boolean living_room = constraint.interpret("living_room", json,house);
            boolean bedroom = constraint.interpret("bedroom", json,house);
            boolean bathroom = constraint.interpret("bathroom", json,house);
            boolean laundry_room = constraint.interpret("laundry_room", json,house);
            boolean entry = constraint.interpret("entry", json,house);
            boolean dinning_room = constraint.interpret("dinning_room", json,house);
            boolean game_room = constraint.interpret("game_room", json,house);
            return game_room && dinning_room && entry && laundry_room && bathroom && bedroom && living_room && kitchen && garden;
        }
        return true;
    }

}
