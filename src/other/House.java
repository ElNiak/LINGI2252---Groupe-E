package other;

import device.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sensor.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class House {
    private List<Room> ground_floor;
    private List<Room> first_floor;
    private Room garden;
    private List<Environnement> environnements;

    public House(String json){
        environnements = new ArrayList<Environnement>();
        ground_floor = new ArrayList<Room>();
        first_floor = new ArrayList<Room>();
        decode_json(json);
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
            ls.add(create_sensor((String) sensor.get("name"), Double.parseDouble((String) sensor.get("x")), Double.parseDouble((String)  sensor.get("y")), Double.parseDouble((String) sensor.get("z")), room, Boolean.parseBoolean((String) sensor.get("activated"))));
        }
    }

    private Sensor create_sensor(String sensor_name, double x, double y, double z, Room room, boolean activated){
        switch (sensor_name){
            case "Camera":
                return new Camera(x, y ,z, room,activated);
            case "LightSensor":
                return new LightSensor(x, y, z, room,activated);
            case "PollutionSensor":
                return new PollutionSensor(x, y, z, room,activated);
            case "MovementSensor":
                return new MovementSensor(x, y, z, room,activated);
            case "TemperatureSensor":
                return new TemperatureSensor(x, y, z, room,activated);
            case "HumiditySensor":
                return new HumiditySensor(x, y, z, room,activated);
            case "SoundSensor":
                return new SoundSensor(x, y, z, room,activated);
            default:
                return new LightSensor(x, y, z, room,activated);
        }
    }

    private void decode_devices(JSONArray devices, List<Device> ld, Room room){
        for(int i = 0; i<devices.size(); i++){
            JSONObject device = (JSONObject) devices.get(i);
            ld.add(create_device((String) device.get("name"), Double.parseDouble((String) device.get("x")), Double.parseDouble((String) device.get("y")), Double.parseDouble((String) device.get("y")), room, Boolean.parseBoolean((String) device.get("activated"))));
        }
    }

    private Device create_device(String device_name, double x, double y, double z, Room room, boolean activated){
        switch (device_name){
            case "AirConditioning":
                return new AirConditioning(x, y, z, room,activated);
            case "Heating":
                return new Heating(x, y, z, room,activated);
            case "Hifi":
                return new Hifi(x, y, z, room,activated);
            case "Humidifier":
                return new Humidifier(x, y, z, room,activated);
            case "Light":
                return new Light(x, y, z, room,activated);
            case "ShutterWindow":
                return new ShutterWindow(x, y, z, room,activated);
            case "Tv":
                return new Tv(x, y, z, room,activated);
            case "Ventilation":
                return new Ventilation(x, y, z, room,activated);
            case "Window":
                return new Windows(x, y, z, room,activated);
            default:
                return new Light(x, y, z, room,activated);
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
