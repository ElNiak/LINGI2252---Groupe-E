import device.Device;
import other.Constants;
import other.House;
import other.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simulation {
    public static void main(String[] args){
        scenario();
    }

    public static void scenario(){
        System.out.println("\n\"Jean is watching TV during the night when suddenly he needs to go to the toilet,\n" +
                " during this time, the movement sensor detect that he leaves the room and then switch off the\n " +
                "TV and the lamp.\"\n");

        House house = new House();

        Room[] first_floor = house.getFirst_floor();
        Room[] ground_floor = house.getGround_floor();

        System.out.println("****** " + ground_floor[1].getName() + " ******");
        List<Device> list = ground_floor[1].getDevices();
        list.get(6).start();
        list.get(7).start();
        list.get(10).start();

        System.out.println("\n\"He needs to go to the toilet\n");
        System.out.println("Jean leaves the room\"\n");
        ground_floor[1].getSensors().get(1).detect();

        System.out.println("\n\"He comes back in the room\"\n");
        ground_floor[1].getSensors().get(1).detect();
    }
}
