import device.Device;
import other.House;
import other.Room;

import java.util.List;

public class Simulation {
    public static void main(String[] args){
        System.out.println("\n ============ SCENARIO 1 ============ \n");
        scenario1();
        System.out.println("\n ============ SCENARIO 2 ============ \n");
        scenario2();
        System.out.println("\n ============ SCENARIO 3 ============ \n");
        scenario3();
    }

    public static void scenario1(){
        System.out.println("\n\"Jean is watching TV during the night when suddenly he needs to go to the toilet,\n" +
                " during this time, the movement sensor detect that he leaves the room and then switch off the\n " +
                "TV and the lamp.\"\n");

        House house = new House(System.getProperty("user.dir") + "/src/res/p1.json");
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();

        System.out.println("****** " + ground_floor.get(1).getName() + " ******");
        List<Device> list = ground_floor.get(1).getDevices();
        list.get(6).manage_device(); //Start devices for the 1st time
        list.get(7).manage_device();
        list.get(11).manage_device();

        System.out.println("\n\"He needs to go to the toilet\n");
        System.out.println("Jean leaves the room\"\n");
        ground_floor.get(1).getSensors().get(3).detect();

        System.out.println("\n\"He comes back in the room\"\n");
        ground_floor.get(1).getSensors().get(3).detect();
    }

    public static void scenario2(){
        House house = new House(System.getProperty("user.dir") + "/src/res/p1.json");
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();
        List<Device> list = first_floor.get(0).getDevices();
        List<Device> list2 = ground_floor.get(2).getDevices();

        System.out.println("\n\"It’s a Sunday in summer. At 8 a.m. when Jean wake up, the movement sensors detects his activity and\n" +
                "the all shutters windows of the house open.\"\n");

        list.get(1).manage_device();//Start devices for the 1st time
        list.get(3).manage_device();


        System.out.println("****** " + first_floor.get(0).getName() + " ******");

        first_floor.get(0).getSensors().get(3).detect();

        System.out.println("\n\"Because sun shine all the light sensors of the house detects that\n" +
                "lamps should not be switched on. Later that day, Jean decides to open the window of the kitchen to enjoy\n" +
                "this beautiful day when he prepare the dinner. But the heating sensor detects that the temperature of the\n" +
                "kitchen become too high because of his dinner preparation and the exterior temperature that enter by the\n" +
                "window.The pollution sensor also detects a too high level of fine particle outdoors. So the window closes and\n" +
                "the air conditioning lights up\"\n");

        list2.get(1).manage_device();//Start devices for the 1st time

        System.out.println("****** " + ground_floor.get(2).getName() + " ******");

        ground_floor.get(2).getSensors().get(0).detect();
        ground_floor.get(2).getSensors().get(1).detect();

    }

    public static void scenario3(){

    }
}
