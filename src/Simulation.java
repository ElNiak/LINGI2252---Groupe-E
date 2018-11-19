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
        System.out.println("\n ============ SCENARIO 3 ============ \n");
        Scanner scan = new Scanner(System.in); //entrée standard,peut aussi prendre un Reader ou un nom de fichier en paramètre
        console(new House(System.getProperty("user.dir") + "/src/res/p1.json"),scan);

    }

    public static void scenario1() {
        System.out.println("\n\"Jean is watching TV during the night when suddenly he needs to go to the toilet,\n" +
                " during this time, the movement sensor detect that he leaves the room and then switch off the\n " +
                "TV and the lamp.\"\n");

        House house = new House(System.getProperty("user.dir") + "/src/res/p1.json");
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();

        System.out.println("****** " + ground_floor.get(1).getName() + " ******");
        List<Device> list = ground_floor.get(1).getDevices();
        house.getGround_floor().get(1).setMovement(1.0); //he is in the room

        System.out.println("\n\"He needs to go to the toilet\n");
        house.getGround_floor().get(1).setMovement(0.0); //leave the room

        System.out.println("\n\"He comes back in the room\"\n");

        house.getGround_floor().get(1).setMovement(1.0); //come back in the room
    }

    public static void scenario2() {
        House house = new House(System.getProperty("user.dir") + "/src/res/p1.json");
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();

        List<Device> list = first_floor.get(0).getDevices();
        List<Device> list2 = ground_floor.get(2).getDevices();

        System.out.println("\n\"It’s a Sunday in summer. At 8 a.m. when Jean wake up, the movement sensors detects his activity and\n" +
                "the all shutters windows of the house open.\"\n");


        first_floor.get(0).setLight(first_floor.get(0).getLight() + 10);

        //list.get(1).manage_device();//Start devices for the 1st time
        //list.get(3).manage_device();


        System.out.println("\n****** " + first_floor.get(0).getName() + " ******");

        //first_floor.get(0).getSensors().get(3).detect();

        System.out.println("\n\"Because sun shine all the light sensors of the house detects that\n" +
                "lamps should not be switched on. Later that day, Jean decides to open the window of the kitchen to enjoy\n" +
                "this beautiful day when he prepare the dinner. But the heating sensor detects that the temperature of the\n" +
                "kitchen become too high because of his dinner preparation and the exterior temperature that enter by the\n" +
                "window. The pollution sensor also detects a too high level of fine particle outdoors. So the window closes and\n" +
                "the air conditioning lights up\"\n");


        ground_floor.get(2).getDevices().get(1).manage_device(); //hardcode pour dire que c'etait deja ouvert



        //list2.get(1).manage_device();//Start devices for the 1st time
        //list2.get(4).manage_device();

        System.out.println("\n****** " + ground_floor.get(2).getName() + " ******\n");

        ground_floor.get(2).setLight(ground_floor.get(2).getLight() + 10);
        ground_floor.get(2).setTemp(ground_floor.get(2).getTemp() + 10);
        ground_floor.get(2).setPollution(ground_floor.get(2).getPollution() + 10);


        //ground_floor.get(2).getSensors().get(0).detect();
        //ground_floor.get(2).getSensors().get(1).detect();

    }

    public static void scenario3() {

    }

    public static void console(House house, Scanner scan) {
        List<Environnement> environnement = house.getEnvironnements();
        System.out.println("=> What do you want to do ? (x = value, POS = index of the room in the json)");
        System.out.println("    - temp(x) POS ");
        System.out.println("    - hum(x) POS ");
        System.out.println("    - light(x) POS ");
        System.out.println("    - wind(x) POS ");
        System.out.println("    - db(x) POS ");
        System.out.println("    - move(x) POS ");
        System.out.println("    - EXIT ");
        try {
            // retourne true s’il y a un autre élément dans l’entrée
            if(scan.hasNext()){
                String res = scan.nextLine(); //retourne la prochaine ligne complète
                System.out.println(res);
                int i = Integer.parseInt(res.substring(res.indexOf(")") + 2, res.length()));
                int add = Integer.parseInt(res.substring(res.indexOf("(") + 1, res.indexOf(")")));
                System.out.println(environnement.get(i).getTemp());
                if (res.contains("temp")) {
                    environnement.get(i).setTemp(environnement.get(i).getTemp() + add);
                } else if (res.contains("hum")) {
                    environnement.get(i).setHum(environnement.get(i).getHum() + add);
                } else if (res.contains("light")) {
                    environnement.get(i).setLight(environnement.get(i).getLight() + add);
                } else if (res.contains("wind")) {
                    environnement.get(i).setWind(environnement.get(i).getWind() + add);
                } else if (res.contains("db")) {
                    environnement.get(i).setDbel(environnement.get(i).getDbel() + add);
                } else if (res.contains("move")) {
                    environnement.get(i).setMovement(1.0);
                } else if (res.contains("EXIT")) {
                } else {
                    System.out.println("Error, retry please.");
                }
                System.out.println(environnement.get(i).getTemp());
            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        //scan.close();
        retry(house, scan);
    }

    public static void retry(House house, Scanner scan){
        System.out.println("\n Would you like to modify anything else ? (Y/N)");
        scan = new Scanner(System.in); //entrée standard,peut aussi prendre un Reader ou un nom de fichier en paramètre
        try {
            // retourne true s’il y a un autre élément dans l’entrée
            if(scan.hasNext()){
                String res = scan.nextLine(); //retourne la prochaine ligne complète
                if(res.equals("Y")){
                    console(house, scan);
                }
                else {
                    scan.close();
                }
            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
