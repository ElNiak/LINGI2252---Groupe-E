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
        Scanner scan = new Scanner(System.in); //entrée standard,peut aussi prendre un Reader ou un nom de fichier en paramètre
        console(House.getInstance(),scan);

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

        //list.get(1).manage_device();//Start devices for the 1st time
        //list.get(3).manage_device();


        //first_floor.get(0).getSensors().get(3).detect();

        System.out.println("\n\"Because sun shine all the light sensors of the house detects that\n" +
                "lamps should not be switched on. Later that day, Jean decides to open the window of the kitchen to enjoy\n" +
                "this beautiful day when he prepare the dinner. But the heating sensor detects that the temperature of the\n" +
                "kitchen become too high because of his dinner preparation and the exterior temperature that enter by the\n" +
                "window. The pollution sensor also detects a too high level of fine particle outdoors. So the window closes and\n" +
                "the air conditioning lights up\"\n");


       // ground_floor.get(2).getDevices().get(2).manage_device(); //hardcode pour dire que c'etait deja ouvert


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

    public static void console(House house, Scanner scan) {
        List<Room> first_floor = house.getFirst_floor();
        List<Room> ground_floor = house.getGround_floor();
        System.out.println("\n=> What do you want to do ? (x = value (double, not integer), POS = index of the room in the json, STAGE = 1 || 2)");
        System.out.println("    - temp(x) POS:STAGE");
        System.out.println("    - hum(x) POS:STAGE");
        System.out.println("    - light(x) POS:STAGE");
        System.out.println("    - wind(x) POS:STAGE");
        System.out.println("    - db(x) POS:STAGE");
        System.out.println("    - move(x) POS:STAGE (x = 1.0 || 0.0)");
        System.out.println("    - activationD(x) POS:STAGE (x = pos of device)");
        System.out.println("    - activationS(x) POS:STAGE (x = pos of sensor)");
        System.out.println("    - desactivationD(x) POS:STAGE (x = pos of device)");
        System.out.println("    - desactivationS(x) POS:STAGE (x = pos of sensor)");
        System.out.println("    - EXIT\n");
        try {
            // retourne true s’il y a un autre élément dans l’entrée
            if(scan.hasNext()){
                String res = scan.nextLine(); //retourne la prochaine ligne complète
                System.out.println(res);
                int i = Integer.parseInt(res.substring(res.indexOf(")") + 2, res.indexOf(":")));
                double add = Double.parseDouble(res.substring(res.indexOf("(") + 1, res.indexOf(")")));
                int stage = Integer.parseInt(res.substring(res.indexOf(":") + 1,res.length()));

                if (stage == 1) {
                    System.out.println("\n- Before :");
                    System.out.println("Environnement = " +ground_floor.get(i).getEnvironnement().toString() + "\n");

                    if (res.contains("temp")) {
                        ground_floor.get(i).setTemp(ground_floor.get(i).getTemp() + add);
                    } else if (res.contains("hum")) {
                        ground_floor.get(i).setHum(ground_floor.get(i).getHum() + add);
                    } else if (res.contains("light")) {
                        ground_floor.get(i).setLight(ground_floor.get(i).getLight() + add);
                    } else if (res.contains("wind")) {
                        ground_floor.get(i).setWind(ground_floor.get(i).getWind() + add);
                    } else if (res.contains("db")) {
                        ground_floor.get(i).setDbel(ground_floor.get(i).getDbel() + add);
                    } else if (res.contains("move")) {
                        ground_floor.get(i).setMovement(add);
                    } else if (res.contains("desactivationD")) {
                        ground_floor.get(i).desactivationD(add);
                    } else if (res.contains("desactivationS")) {
                        ground_floor.get(i).desactivationS(add);
                    } else if (res.contains("activationD")) {
                        ground_floor.get(i).activationD(add);
                    } else if (res.contains("activationS")) {
                        ground_floor.get(i).activationS(add);
                    } else if (res.contains("EXIT")) {
                        scan.close();
                        return;
                    } else {
                        System.out.println("Error, retry please.\n");
                    }

                    System.out.println("\n- After :");
                    System.out.println("Environnement = " +ground_floor.get(i).getEnvironnement().toString() + "\n");
                }
                else if (stage == 2){
                    System.out.println("\n- Before :");
                    System.out.println("Environnement = " +first_floor.get(i).getEnvironnement().toString() + "\n");

                    if (res.contains("temp")) {
                        first_floor.get(i).setTemp(first_floor.get(i).getTemp() + add);
                    } else if (res.contains("hum")) {
                        first_floor.get(i).setHum(first_floor.get(i).getHum() + add);
                    } else if (res.contains("light")) {
                        first_floor.get(i).setLight(first_floor.get(i).getLight() + add);
                    } else if (res.contains("wind")) {
                        first_floor.get(i).setWind(first_floor.get(i).getWind() + add);
                    } else if (res.contains("db")) {
                        first_floor.get(i).setDbel(first_floor.get(i).getDbel() + add);
                    } else if (res.contains("move")) {
                        first_floor.get(i).setMovement(add);
                    } else if (res.contains("desactivationD")) {
                        ground_floor.get(i).desactivationD(add);
                    } else if (res.contains("desactivationS")) {
                        ground_floor.get(i).desactivationS(add);
                    } else if (res.contains("activationD")) {
                        ground_floor.get(i).activationD(add);
                    } else if (res.contains("activationS")) {
                        ground_floor.get(i).activationS(add);
                    } else if (res.contains("EXIT")) {
                        scan.close();
                        return;
                    } else {
                        System.out.println("Error, retry please.");
                    }

                    System.out.println("\n- After :");
                    System.out.println("Environnement = " +first_floor.get(i).getEnvironnement().toString() + "\n");
                    }
                else {
                    System.out.println("Invalid number of stage");
                }
            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Retry with a valid number");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Retry with a valid command");
        }
        if(House.check_feature_model(house))
            retry(house, scan);
        else
            System.out.println("Feature models not respected");
    }

    public static void retry(House house, Scanner scan){

        System.out.println("\n Would you like to modify anything else ? (Y/N)\n");
        //scan = new Scanner(System.in); //entrée standard,peut aussi prendre un Reader ou un nom de fichier en paramètre
        try {
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
