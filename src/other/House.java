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

        //kitchen

        //dinning room


        /*
         * FIRST FLOOR
         */

        //bedroom

        //bathroom

        //game room

        //laundry room


    }
}
