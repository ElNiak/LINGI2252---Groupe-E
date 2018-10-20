package other;

import device.*;
import sensor.*;

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
        entry_sensors.add(new LightSensor(350, 700, 350, entry));
        entry_sensors.add(new PollutionSensor(350, 700, 450, entry));
        entry_sensors.add(new MovementSensor(350, 700, 450, entry));

        entry_devices.add(new Light(350, 700, 350, entry));

        //living room
        Environnement living_room_env = new Environnement();
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
