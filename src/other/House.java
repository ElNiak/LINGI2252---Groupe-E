package other;

import device.*;
import interpreter.constraint.JSONConstraint;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.reflections.Reflections;
import sensor.*;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class House {
    private static House instance = new House(System.getProperty("user.dir") + "/src/res/configuration.json");
    private List<Room> ground_floor;
    private List<Room> first_floor;
    private List<Sensor> sensors_l;
    private List<Device> devices_l;
    private Room garden;
    private List<Environnement> environnements;

    public House(String json){
        sensors_l = new ArrayList<Sensor>();
        devices_l  = new ArrayList<Device>();
        environnements = new ArrayList<Environnement>();
        ground_floor = new ArrayList<Room>();
        first_floor = new ArrayList<Room>();
        decode_json(json);
    }

    public static House getInstance(){
        JSONConstraint.decode_constraint(System.getProperty("user.dir") + "/src/res/feature_model.json",instance);
        try{
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");

            if((boolean) jo.get("value")) {
                return instance;
            } else {
                System.out.println("Error : feature model not respected");
                System.exit(-1);
                return null;
            }
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return null;
    }


    public void refresh(){
        sensors_l = new LinkedList<>();
        devices_l = new LinkedList<>();
        if(garden != null) {
            devices_l.addAll(garden.getDevices());
            sensors_l.addAll(garden.getSensors());
        }
        for (Room r : ground_floor) {
            devices_l.addAll(r.getDevices());
            sensors_l.addAll(r.getSensors());
        }
        for (Room r : first_floor) {
            devices_l.addAll(r.getDevices());
            sensors_l.addAll(r.getSensors());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(ground_floor, house.ground_floor) &&
                Objects.equals(first_floor, house.first_floor) &&
                Objects.equals(garden, house.garden) &&
                Objects.equals(environnements, house.environnements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ground_floor, first_floor, garden, environnements);
    }

    @Override
    public String toString() {
        return "House{" + "\n" +
                "ground_floor=" + Arrays.toString(ground_floor.toArray()) + "\n" +
                ", first_floor=" + Arrays.toString(first_floor.toArray()) + "\n" +
                ", garden=" + garden + "\n" +
                ", environnements=" + Arrays.toString(environnements.toArray()) + "\n" +
                '}';
    }

    public void decode_json(String json){
        try{
            Object o1 = new JSONParser().parse(new FileReader(json));
            JSONObject jo = (JSONObject) o1;

            JSONObject jo2 = (JSONObject) jo.get("house");
            String[] floors = {"first_floor", "second_floor", "Garden"};

            for(int i = 0; i<floors.length; i++){
                JSONObject floor = (JSONObject) jo2.get(floors[i]);
                JSONArray rooms = (JSONArray) floor.get("rooms");
                decode_rooms(rooms, floors[i]);
            }
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public boolean containS(String sensor){
        this.refresh();
        switch (sensor) {
            case "humidity" :
                for (Sensor s:sensors_l) {
                    if(s instanceof HumiditySensor && s.isActivated())
                        return true;
                }
                return false;
            case "light" :
                for (Sensor s:sensors_l) {
                    if(s instanceof LightSensor && s.isActivated()) {
                        return true;
                    }
                }
                return false;
            case "temperature" :
                for (Sensor s:sensors_l) {
                    if(s instanceof TemperatureSensor && s.isActivated())
                        return true;
                }
                return false;
            case "pollution" :
                for (Sensor s:sensors_l) {
                    if(s instanceof PollutionSensor && s.isActivated())
                        return true;
                }
                return false;
            case "wind" :
                for (Sensor s:sensors_l) {
                    if(s instanceof WindSensor && s.isActivated())
                    return true;
                }
                return false;
            case "sonore" :
                for (Sensor s:sensors_l) {
                    if(s instanceof SoundSensor && s.isActivated())
                        return true;
                }
                return false;
            case "movement" :
                for (Sensor s:sensors_l) {
                    if(s instanceof MovementSensor && s.isActivated())
                        return true;
                }
                return false;
            case "camera" :
                for (Sensor s:sensors_l) {
                    if(s instanceof Camera && s.isActivated())
                        return true;
                }
                return false;
            default:
                return false;
        }
    }


    public boolean containR(String room){
        this.refresh();
            switch (room) {
                case "garden" :
                    return garden == null;
                case "kitchen" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("Kitchen") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("Kitchen") && rooms.isActivated())
                            return true;
                    }
                    return false;
                case "living_room" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("LivingRoom") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("LivingRoom") && rooms.isActivated())
                            return true;
                    }
                    return false;
                case "bedroom" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("BedRoom") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("BedRoom") && rooms.isActivated())
                            return true;
                    }
                    return false;
                case "bathroom" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("BathRoom") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("BathRoom") && rooms.isActivated())
                            return true;
                    }
                    return false;
                case "laundry_room" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("LaundryRoom") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("LaundryRoom") && rooms.isActivated())
                            return true;
                    }
                    return false;
                case "entry" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("Entry") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("Entry") && rooms.isActivated())
                            return true;
                    }
                    return false;
                case "dinning_room" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("DinningRoom") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("DinningRoom") && rooms.isActivated())
                            return true;
                    }
                    return false;
                case "game_room" :
                    for (Room rooms : first_floor) {
                        if (rooms.getName().equals("GameRoom") && rooms.isActivated())
                            return true;
                    }
                    for (Room rooms : ground_floor) {
                        if (rooms.getName().equals("GameRoom") && rooms.isActivated())
                            return true;
                    }
                    return false;
                default:
                    return true;
            }
    }

    private void decode_rooms(JSONArray rooms, String floor){
        for(int i = 0; i<rooms.size(); i++){
            Environnement env = new Environnement();
            environnements.add(env);
            List<Sensor> sensors = new ArrayList<Sensor>();
            List<Device> devices = new ArrayList<Device>();
            JSONObject jsonObject = (JSONObject) rooms.get(i);
            Room room = new Room((String) jsonObject.get("name"), Double.parseDouble((String)jsonObject.get("height")), Double.parseDouble((String) jsonObject.get("width")), Double.parseDouble((String) jsonObject.get("length")), env, sensors, devices);
            env.setRoom(room);
            decode_sensors((JSONArray) jsonObject.get("sensors"), sensors, room);
            decode_devices((JSONArray) jsonObject.get("devices"), devices, room);
            if(floor.equals("first_floor")){
                ground_floor.add(room);
            }
            else if(floor.equals("second_floor")){
                first_floor.add(room);
            }
            else{
                garden = room;
            }
        }
    }

    private void decode_sensors(JSONArray sensors, List<Sensor> ls, Room room){
        for(int i = 0; i<sensors.size(); i++){
            JSONObject sensor = (JSONObject) sensors.get(i);
            sensors_l.add(room.create_sensor((String) sensor.get("name"), Double.parseDouble((String) sensor.get("x")), Double.parseDouble((String)  sensor.get("y")), Double.parseDouble((String) sensor.get("z")), room, Boolean.parseBoolean((String) sensor.get("activated"))));
            ls.add(room.create_sensor((String) sensor.get("name"), Double.parseDouble((String) sensor.get("x")), Double.parseDouble((String)  sensor.get("y")), Double.parseDouble((String) sensor.get("z")), room, Boolean.parseBoolean((String) sensor.get("activated"))));
        }
    }

    private void decode_devices(JSONArray devices, List<Device> ld, Room room){
        for(int i = 0; i<devices.size(); i++){
            JSONObject device = (JSONObject) devices.get(i);
            devices_l.add(room.create_device((String) device.get("name"), Double.parseDouble((String) device.get("x")), Double.parseDouble((String) device.get("y")), Double.parseDouble((String) device.get("y")), room, Boolean.parseBoolean((String) device.get("activated"))));
            ld.add(room.create_device((String) device.get("name"), Double.parseDouble((String) device.get("x")), Double.parseDouble((String) device.get("y")), Double.parseDouble((String) device.get("y")), room, Boolean.parseBoolean((String) device.get("activated"))));
        }
    }


    public List<Room> getGround_floor() {
        return ground_floor;
    }

    public void setGround_floor(List<Room> ground_floor) {
        this.ground_floor = ground_floor;
    }

    public List<Room> getFirst_floor() {
        return first_floor;
    }

    public void setFirst_floor(List<Room> first_floor) {
        this.first_floor = first_floor;
    }

    public Room getGarden() {
        return garden;
    }

    public void setGarden(Room garden) {
        this.garden = garden;
    }

    public List<Environnement> getEnvironnements() {
        return environnements;
    }

    public void setEnvironnements(List<Environnement> environnements) {
        this.environnements = environnements;
    }

    public Room getRoomFirstFloor(String s){
        for(Room r : first_floor){
            if(s.equals(r.getName())){
                return r;
            }
        }
        return null;
    }

    public Room getRoomGroundFloor(String s){
        for(Room r : ground_floor){
            if(s.equals(r.getName())){
                return r;
            }
        }
        return null;
    }

}
