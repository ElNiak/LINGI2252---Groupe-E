package other;

import device.Device;
import sensor.Camera;
import sensor.Sensor;

import java.util.ArrayList;
import java.util.List;

public class House {
    Room[] ground_floor;
    Room[] first_floor;
    Environnement[] environnements;

    public House(){
        create_house();
    }

    private void create_house(){
        environnements = new Environnement[8];

        /*
         * GROUND FLOOR
         */

        //Entry
        Environnement entry_env = new Environnement();
        List<Sensor> entry_sensors = new ArrayList<Sensor>();
        List<Device> entry_devices = new ArrayList<Device>();
        Room entry = new Room("Entry", 300, 700, 700, entry_env, entry_sensors, entry_devices);
        entry_env.setRoom(entry);
        entry_sensors.add(new Camera(350, 700, 300, entry));

        //living room
        Environnement living_room_env = new Environnement();
        List<Sensor> living_room_sensors = new ArrayList<Sensor>();
        List<Device> living_room_devices = new ArrayList<Device>();
        Room living_room = new Room("Living Room", 300, 700, 700, living_room_env, living_room_sensors, living_room_devices);
        living_room_env.setRoom(living_room);

        //kitchen
        Environnement kitchen_env = new Environnement();
        List<Sensor> kitchen_sensors = new ArrayList<Sensor>();
        List<Device> kitchen_devices = new ArrayList<Device>();
        Room kitchen = new Room("Kitchen", 300, 700, 700, kitchen_env, kitchen_sensors, kitchen_devices);
        kitchen_env.setRoom(kitchen);

        //dinning room
        Environnement dinning_room_env = new Environnement();
        List<Sensor> dinning_room_sensors = new ArrayList<Sensor>();
        List<Device> dinning_room_devices = new ArrayList<Device>();
        Room dinning_room = new Room("Dinning Room", 300, 700, 700, dinning_room_env, dinning_room_sensors, dinning_room_devices);
        dinning_room_env.setRoom(dinning_room);


        /*
         * FIRST FLOOR
         */

        //bedroom
        Environnement bedroom_env = new Environnement();
        List<Sensor> bedroom_sensors = new ArrayList<Sensor>();
        List<Device> bedroom_devices = new ArrayList<Device>();
        Room bedroom = new Room("Bedroom", 300, 700, 700, bedroom_env, bedroom_sensors, bedroom_devices);
        bedroom_env.setRoom(bedroom);

        //bathroom
        Environnement bathroom_env = new Environnement();
        List<Sensor> bathroom_sensors = new ArrayList<Sensor>();
        List<Device> bathroom_devices = new ArrayList<Device>();
        Room bathroom = new Room("Bathroom", 300, 700, 700, bathroom_env, bathroom_sensors, bathroom_devices);
        bathroom_env.setRoom(bathroom);

        //game room
        Environnement game_room_env = new Environnement();
        List<Sensor> game_room_sensors = new ArrayList<Sensor>();
        List<Device> game_room_devices = new ArrayList<Device>();
        Room game_room = new Room("Game Room", 300, 700, 700, game_room_env, game_room_sensors, game_room_devices);
        game_room_env.setRoom(game_room);

        //laundry room
        Environnement laundry_room_env = new Environnement();
        List<Sensor> laundry_room_sensors = new ArrayList<Sensor>();
        List<Device> laundry_room_devices = new ArrayList<Device>();
        Room laundry_room = new Room("Laundry Room", 300, 700, 700, laundry_room_env, laundry_room_sensors, laundry_room_devices);
        laundry_room_env.setRoom(laundry_room);


    }
}
