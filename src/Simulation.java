import device.Device;
import other.Constants;
import other.House;
import other.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simulation {
    public static void main(String[] args){
        System.out.println("\n ============ SCENARIO 1 ============ \n");
        scenario1();
        System.out.println("\n ============ SCENARIO 2 ============ \n");
        scenario2();
    }

    public static void scenario1(){
        System.out.println("\n\"Jean is watching TV during the night when suddenly he needs to go to the toilet,\n" +
                " during this time, the movement sensor detect that he leaves the room and then switch off the\n " +
                "TV and the lamp.\"\n");

        House house = new House(System.getProperty("user.dir") + "/src/parametrisation/p1.json");

        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();

        System.out.println("****** " + ground_floor.get(1).getName() + " ******");
        List<Device> list = ground_floor.get(1).getDevices();
        list.get(6).start();
        list.get(7).start();
        list.get(11).start();

        System.out.println("\n\"He needs to go to the toilet\n");
        System.out.println("Jean leaves the room\"\n");
        ground_floor.get(1).getSensors().get(3).detect();

        System.out.println("\n\"He comes back in the room\"\n");
        ground_floor.get(1).getSensors().get(3).detect();
    }

    public static void scenario2(){

    }
}
