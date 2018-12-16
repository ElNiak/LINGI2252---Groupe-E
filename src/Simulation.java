import device.Device;
import other.Environnement;
import other.House;
import other.Room;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) {
        System.out.println("\n ============ SCENARIO 1 ============ \n");
        scenario1();
        System.out.println("\n ============ SCENARIO 2 ============ \n");
        scenario2();
        System.out.println("\n ============ SCENARIO 3 ============ \n");
        scenario3();
        System.out.println("\n ============  CONSOLE   ============ \n");
        Parametrisation parametrisation = new SpecificParametrisation(new Scanner(System.in));
        parametrisation.console();

    }

    public static void scenario1() {
        System.out.println("\n\"Jean is watching TV during the night when suddenly he needs to go to the toilet,\n" +
                " during this time, the movement sensor detect that he leaves the room and then switch off the\n " +
                "TV and the lamp.\"\n");

        House house = House.getInstance();
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();

        System.out.println("****** " + ground_floor.get(1).getName() + " ******\n");
        List<Device> list = ground_floor.get(1).getDevices();
        house.getGround_floor().get(1).setMovement(1.0); //he is in the room

        System.out.println("\n\"He needs to go to the toilet\n");
        house.getGround_floor().get(1).setMovement(0.0); //leave the room

        System.out.println("\n\"He comes back in the room\"\n");

        house.getGround_floor().get(1).setMovement(1.0); //come back in the room
    }

    public static void scenario2() {
        House house = House.getInstance();
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();

        List<Device> list = first_floor.get(0).getDevices();
        List<Device> list2 = ground_floor.get(2).getDevices();

        System.out.println("\n\"It’s a Sunday in summer. At 8 a.m. when Jean wake up, the movement sensors detects his activity and\n" +
                "the all shutters windows of the house open.\"\n");

        System.out.println("****** " + first_floor.get(0).getName() + " ******\n");

        first_floor.get(0).setLight(first_floor.get(0).getLight() + 10);

        System.out.println("\n\"Because sun shine all the light sensors of the house detects that\n" +
                "lamps should not be switched on. Later that day, Jean decides to open the window of the kitchen to enjoy\n" +
                "this beautiful day when he prepare the dinner. But the heating sensor detects that the temperature of the\n" +
                "kitchen become too high because of his dinner preparation and the exterior temperature that enter by the\n" +
                "window. The pollution sensor also detects a too high level of fine particle outdoors. So the window closes and\n" +
                "the air conditioning lights up\"\n");

        System.out.println("\n****** " + ground_floor.get(2).getName() + " ******\n");

        ground_floor.get(2).setLight(ground_floor.get(2).getLight() + 10);
        ground_floor.get(2).setTemp(ground_floor.get(2).getTemp() + 10);
        ground_floor.get(2).setPollution(ground_floor.get(2).getPollution() + 10);

    }

    public static void scenario3() {
        House house = House.getInstance();
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();

        System.out.println("During a cold night, Jean Martin decides to take a shower so the humidity goes up and the light turns on.\n");
        first_floor.get(1).setTemp(first_floor.get(1).getTemp() - 10);
        first_floor.get(1).setHum(first_floor.get(1).getHum() + 10);
        first_floor.get(1).setMovement(1.0);

        System.out.println("\nWhen he finished he leaves the room and the light switch off");
        first_floor.get(1).setMovement(0.0);
        //first_floor.get(1).setTemp(first_floor.get(1).getTemp() + 10);

        System.out.println("\nThen he go to his bedroom in order to dress up.");
        first_floor.get(0).setMovement(1.0);
        first_floor.get(0).setTemp(first_floor.get(0).getTemp() - 10);
    }
}
