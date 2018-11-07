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

    public House(){
        environnements = new ArrayList<Environnement>();
        ground_floor = new ArrayList<Room>();
        first_floor = new ArrayList<Room>();
        create_house();
    }


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
        return "House{" +
                "ground_floor=" + Arrays.toString(ground_floor.toArray()) +
                ", first_floor=" + Arrays.toString(first_floor.toArray()) +
                ", garden=" + garden +
                ", environnements=" + Arrays.toString(environnements.toArray()) +
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
            ls.add(create_sensor((String) sensor.get("name"), Double.parseDouble((String) sensor.get("x")), Double.parseDouble((String)  sensor.get("y")), Double.parseDouble((String) sensor.get("z")), room));
        }
    }

    private Sensor create_sensor(String sensor_name, double x, double y, double z, Room room){
        switch (sensor_name){
            case "Camera":
                return new Camera(x, y ,z, room);
            case "LightSensor":
                return new LightSensor(x, y, z, room);
            case "PollutionSensor":
                return new PollutionSensor(x, y, z, room);
            case "MovementSensor":
                return new MovementSensor(x, y, z, room);
            case "TemperatureSensor":
                return new TemperatureSensor(x, y, z, room);
            case "HumiditySensor":
                return new HumiditySensor(x, y, z, room);
            case "SoundSensor":
                return new SoundSensor(x, y, z, room);
            default:
                return new LightSensor(x, y, z, room);
        }
    }

    private void decode_devices(JSONArray devices, List<Device> ld, Room room){
        for(int i = 0; i<devices.size(); i++){
            JSONObject device = (JSONObject) devices.get(i);
            ld.add(create_device((String) device.get("name"), Double.parseDouble((String) device.get("x")), Double.parseDouble((String) device.get("y")), Double.parseDouble((String) device.get("y")), room));
        }
    }

    private Device create_device(String device_name, double x, double y, double z, Room room){
        switch (device_name){
            case "AirConditioning":
                return new AirConditioning(x, y, z, room);
            case "Heating":
                return new Heating(x, y, z, room);
            case "Hifi":
                return new Hifi(x, y, z, room);
            case "Humidifier":
                return new Humidifier(x, y, z, room);
            case "Light":
                return new Light(x, y, z, room);
            case "ShutterWindow":
                return new ShutterWindow(x, y, z, room);
            case "Tv":
                return new Tv(x, y, z, room);
            case "Ventilation":
                return new Ventillation(x, y, z, room);
            case "Window":
                return new Windows(x, y, z, room);
            default:
                return new Light(x, y, z, room);
        }
    }

    public void create_house(){
        /*
         * GROUND FLOOR
         */

        //Entry
        Environnement entry_env = new Environnement();
        environnements.add(entry_env);
        List<Sensor> entry_sensors = new ArrayList<Sensor>();
        List<Device> entry_devices = new ArrayList<Device>();
        Room entry = new Room("Entry", 300, 700, 700, entry_env, entry_sensors, entry_devices);
        entry_env.setRoom(entry);
        entry_sensors.add(new Camera(350, 700, 300, entry));
        entry_sensors.add(new LightSensor(350, 700, 350, entry));
        entry_sensors.add(new PollutionSensor(350, 700, 450, entry));
        entry_sensors.add(new MovementSensor(350, 700, 450, entry));

        entry_devices.add(new Light(350, 700, 350, entry));

        //living room
        Environnement living_room_env = new Environnement();
        environnements.add(living_room_env);
        List<Sensor> living_room_sensors = new ArrayList<Sensor>();
        List<Device> living_room_devices = new ArrayList<Device>();
        Room living_room = new Room("Living Room", 300, 700, 700, living_room_env, living_room_sensors, living_room_devices);
        living_room_env.setRoom(living_room);
        living_room_sensors.add(new LightSensor(350, 700, 350, living_room));
        living_room_sensors.add(new MovementSensor(350, 700, 350, living_room));
        living_room_sensors.add(new TemperatureSensor(350, 700, 350, living_room));
        living_room_sensors.add(new HumiditySensor(350, 700, 350, living_room));

        living_room_devices.add(new ShutterWindow(350, 700, 350, living_room));
        living_room_devices.add(new ShutterWindow(350, 700, 350, living_room));
        living_room_devices.add(new ShutterWindow(350, 700, 350, living_room));
        living_room_devices.add(new Windows(350, 700, 350, living_room));
        living_room_devices.add(new Windows(350, 700, 350, living_room));
        living_room_devices.add(new Windows(350, 700, 350, living_room));
        living_room_devices.add(new Light(350, 700, 350, living_room));
        living_room_devices.add(new Light(350, 700, 350, living_room));
        living_room_devices.add(new Ventillation(350, 700, 350, living_room));
        living_room_devices.add(new Hifi(350, 700, 350, living_room));
        living_room_devices.add(new Tv(350, 700, 350, living_room));
        living_room_devices.add(new Heating(350, 700, 350, living_room));


        //kitchen
        Environnement kitchen_env = new Environnement();
        environnements.add(kitchen_env);
        List<Sensor> kitchen_sensors = new ArrayList<Sensor>();
        List<Device> kitchen_devices = new ArrayList<Device>();
        Room kitchen = new Room("Kitchen", 300, 700, 700, kitchen_env, kitchen_sensors, kitchen_devices);
        kitchen_env.setRoom(kitchen);
        kitchen_sensors.add(new LightSensor(350, 700, 350, kitchen));
        kitchen_sensors.add(new MovementSensor(350, 700, 350, kitchen));
        kitchen_sensors.add(new TemperatureSensor(350, 700, 350, kitchen));
        kitchen_sensors.add(new HumiditySensor(350, 700, 350, kitchen));

        kitchen_devices.add(new ShutterWindow(350, 700, 350, kitchen));
        kitchen_devices.add(new Windows(350, 700, 350, kitchen));
        kitchen_devices.add(new Light(350, 700, 350, kitchen));
        kitchen_devices.add(new Humidifier(350, 700, 350, kitchen));
        kitchen_devices.add(new Ventillation(350, 700, 350, kitchen));


        //dinning room
        Environnement dinning_room_env = new Environnement();
        environnements.add(dinning_room_env);
        List<Sensor> dinning_room_sensors = new ArrayList<Sensor>();
        List<Device> dinning_room_devices = new ArrayList<Device>();
        Room dinning_room = new Room("Dinning Room", 300, 700, 700, dinning_room_env, dinning_room_sensors, dinning_room_devices);
        dinning_room_env.setRoom(dinning_room);
        dinning_room_sensors.add(new LightSensor(350, 700, 350, dinning_room));
        dinning_room_sensors.add(new MovementSensor(350, 700, 350, dinning_room));
        dinning_room_sensors.add(new TemperatureSensor(350, 700, 350, dinning_room));
        dinning_room_sensors.add(new HumiditySensor(350, 700, 350, dinning_room));

        dinning_room_devices.add(new ShutterWindow(350, 700, 350, dinning_room));
        dinning_room_devices.add(new Windows(350, 700, 350, dinning_room));
        dinning_room_devices.add(new ShutterWindow(350, 700, 350, dinning_room));
        dinning_room_devices.add(new Windows(350, 700, 350, dinning_room));
        dinning_room_devices.add(new Light(350, 700, 350, dinning_room));
        dinning_room_devices.add(new Humidifier(350, 700, 350, dinning_room));
        dinning_room_devices.add(new Ventillation(350, 700, 350, dinning_room));

        ground_floor.add(entry);
        ground_floor.add(living_room);
        ground_floor.add(kitchen);
        ground_floor.add(dinning_room);

        /*
         * FIRST FLOOR
         */

        //bedroom
        Environnement bedroom_env = new Environnement();
        environnements.add(bedroom_env);
        List<Sensor> bedroom_sensors = new ArrayList<Sensor>();
        List<Device> bedroom_devices = new ArrayList<Device>();
        Room bedroom = new Room("Bedroom", 300, 700, 700, bedroom_env, bedroom_sensors, bedroom_devices);
        bedroom_env.setRoom(bedroom);
        bedroom_sensors.add(new MovementSensor(0, 0, 300, bedroom));
        bedroom_sensors.add(new TemperatureSensor(350, 700, 350, bedroom));
        bedroom_sensors.add(new HumiditySensor(350, 700, 350, bedroom));
        bedroom_sensors.add(new LightSensor(350, 700, 350, bedroom));

        bedroom_devices.add(new AirConditioning(350, 0, 300, bedroom));
        bedroom_devices.add(new Heating(350, 0, 0, bedroom));
        bedroom_devices.add(new Light(350, 350, 300, bedroom));
        bedroom_devices.add(new Windows(0, 0, 150, bedroom));
        bedroom_devices.add(new ShutterWindow(0, 0, 150, bedroom));



        //bathroom
        Environnement bathroom_env = new Environnement();
        environnements.add(bathroom_env);
        List<Sensor> bathroom_sensors = new ArrayList<Sensor>();
        List<Device> bathroom_devices = new ArrayList<Device>();
        Room bathroom = new Room("Bathroom", 300, 700, 700, bathroom_env, bathroom_sensors, bathroom_devices);
        bathroom_env.setRoom(bathroom);
        bathroom_sensors.add(new LightSensor(350, 700, 350, bathroom));
        bathroom_sensors.add(new MovementSensor(350, 700, 350, bathroom));
        bathroom_sensors.add(new TemperatureSensor(350, 700, 350, bathroom));
        bathroom_sensors.add(new HumiditySensor(350, 700, 350, bathroom));

        bathroom_devices.add(new ShutterWindow(350, 700, 350, bathroom));
        bathroom_devices.add(new Windows(350, 700, 350, bathroom));
        bathroom_devices.add(new Light(350, 700, 350, bathroom));
        bathroom_devices.add(new Ventillation(350, 700, 350, bathroom));
        bathroom_devices.add(new Heating(350, 700, 350, bathroom));

        //game room
        Environnement game_room_env = new Environnement();
        environnements.add(game_room_env);
        List<Sensor> game_room_sensors = new ArrayList<Sensor>();
        List<Device> game_room_devices = new ArrayList<Device>();
        Room game_room = new Room("Game Room", 300, 700, 700, game_room_env, game_room_sensors, game_room_devices);
        game_room_env.setRoom(game_room);
        game_room_sensors.add(new MovementSensor(0, 0, 300, game_room));
        game_room_sensors.add(new TemperatureSensor(350, 700, 350, game_room));
        game_room_sensors.add(new HumiditySensor(350, 700, 350, game_room));

        game_room_devices.add(new AirConditioning(350, 0, 300, game_room));
        game_room_devices.add(new Heating(350, 0, 0, game_room));
        game_room_devices.add(new Light(350, 350, 300, game_room));
        game_room_devices.add(new Windows(0, 0, 150, game_room));
        game_room_devices.add(new ShutterWindow(0, 0, 150, game_room));

        //laundry room
        Environnement laundry_room_env = new Environnement();
        environnements.add(laundry_room_env);
        List<Sensor> laundry_room_sensors = new ArrayList<Sensor>();
        List<Device> laundry_room_devices = new ArrayList<Device>();
        Room laundry_room = new Room("Laundry Room", 300, 700, 700, laundry_room_env, laundry_room_sensors, laundry_room_devices);
        laundry_room_env.setRoom(laundry_room);
        laundry_room_sensors.add(new MovementSensor(0, 0, 300, laundry_room));

        laundry_room_devices.add(new Light(350, 350, 300, laundry_room));
        laundry_room_devices.add(new Windows(0, 0, 150, laundry_room));
        laundry_room_devices.add(new ShutterWindow(0, 0, 150, laundry_room));

        first_floor.add(bedroom);
        first_floor.add(bathroom);
        first_floor.add(game_room);
        first_floor.add(game_room);

        /*
         * GARDEN
         */

        Environnement garden_env = new Environnement();
        environnements.add(garden_env);
        List<Sensor> garden_sensors = new ArrayList<Sensor>();
        List<Device> garden_devices = new ArrayList<Device>();
        garden = new Room("Garden", 100000, 1500, 1500, garden_env, garden_sensors, garden_devices);
        garden_env.setRoom(garden);
        garden_sensors.add(new LightSensor(350, 700, 350, garden));
        garden_sensors.add(new SoundSensor(350, 700, 350, garden));
        garden_sensors.add(new TemperatureSensor(350, 700, 350, garden));
        garden_sensors.add(new HumiditySensor(350, 700, 350, garden));
        garden_sensors.add(new PollutionSensor(350, 700, 350, garden));

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
