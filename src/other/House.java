package other;

import device.*;
import sensor.*;

import java.util.ArrayList;
import java.util.List;

public class House {
    Room[] ground_floor;
    Room[] first_floor;
    Room garden;
    Environnement[] environnements;

    public House(){
        create_house();
    }

    private void create_house(){
        environnements = new Environnement[9];

        /*
         * GROUND FLOOR
         */

        //Entry
        Environnement entry_env = new Environnement();
        environnements[0] = entry_env;
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
        environnements[1] = living_room_env;
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
        environnements[2] = kitchen_env;
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
        environnements[3] = dinning_room_env;
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

        ground_floor[0] = entry;
        ground_floor[1] = living_room;
        ground_floor[2] = kitchen;
        ground_floor[3] = dinning_room;

        /*
         * FIRST FLOOR
         */

        //bedroom
        Environnement bedroom_env = new Environnement();
        environnements[4] = bedroom_env;
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
        environnements[5] = bathroom_env;
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
        environnements[6] = game_room_env;
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
        environnements[7] = laundry_room_env;
        List<Sensor> laundry_room_sensors = new ArrayList<Sensor>();
        List<Device> laundry_room_devices = new ArrayList<Device>();
        Room laundry_room = new Room("Laundry Room", 300, 700, 700, laundry_room_env, laundry_room_sensors, laundry_room_devices);
        laundry_room_env.setRoom(laundry_room);
        laundry_room_sensors.add(new MovementSensor(0, 0, 300, laundry_room));

        laundry_room_devices.add(new Light(350, 350, 300, laundry_room));
        laundry_room_devices.add(new Windows(0, 0, 150, laundry_room));
        laundry_room_devices.add(new ShutterWindow(0, 0, 150, laundry_room));

        first_floor[0] = bedroom;
        first_floor[1] = bathroom;
        first_floor[2] = game_room;
        first_floor[3] = game_room;

        /*
         * GARDEN
         */

        Environnement garden_env = new Environnement();
        environnements[8] = garden_env;
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
}
