import interpreter.Expression_console;
import interpreter.InterpreterConsole;
import other.House;
import other.Room;
import sensor.*;

import java.util.List;
import java.util.Scanner;

public abstract class Parametrisation {

    private House house;
    private Scanner scanner;
    private InterpreterConsole interpreterConsole;

    public Parametrisation(Scanner scanner){
        house = House.getInstance();
        this.scanner = scanner;
        interpreterConsole = new InterpreterConsole(house);
    }


    public boolean check_feature_model(){
        return check_feature_model(house);
    }

    public boolean check_feature_model(House house){
        if(house.getGround_floor() == null)
            return false;
        if(house.getFirst_floor() == null)
            return false;

        boolean kitchen=false, living=false, bed=false, bath=false, temp=false, light=false, mvt=false, camera=false;
        for(int i = 0; i < house.getGround_floor().size(); i++){
            if(house.getGround_floor().get(i).getName().equals("Kitchen"))
                kitchen = true;
            if(house.getGround_floor().get(i).getName().equals("LivingRoom"))
                living = true;
            if(house.getGround_floor().get(i).getName().equals("BedRoom"))
                bed = true;
            if(house.getGround_floor().get(i).getName().equals("BathRoom"))
                bath = true;

            for(Sensor s:house.getGround_floor().get(i).getSensors()) {
                if(s instanceof TemperatureSensor && s.isActivated())
                    temp = true;
                if(s instanceof LightSensor && s.isActivated())
                    light = true;
                if(s instanceof Camera && s.isActivated())
                    camera = true;
                if(s instanceof MovementSensor && s.isActivated())
                    mvt = true;
            }

        }

        for(int i = 0; i < house.getFirst_floor().size(); i++){
            if(house.getFirst_floor().get(i).getName().equals("Kitchen"))
                kitchen = true;
            if(house.getFirst_floor().get(i).getName().equals("LivingRoom"))
                living = true;
            if(house.getFirst_floor().get(i).getName().equals("BedRoom"))
                bed = true;
            if(house.getFirst_floor().get(i).getName().equals("BathRoom"))
                bath = true;

            for(Sensor s:house.getFirst_floor().get(i).getSensors()) {
                if(s instanceof TemperatureSensor && s.isActivated())
                    temp = true;
                if(s instanceof LightSensor && s.isActivated())
                    light = true;
                if(s instanceof Camera && s.isActivated())
                    camera = true;
                if(s instanceof MovementSensor && s.isActivated())
                    mvt = true;
            }
        }
        return kitchen && light && living && bed && bath && temp && mvt && camera;
    }


    public  void console() {
        System.out.println("\n=> What do you want to do ? (x = value, POS = index of the room in the json, STAGE = 1 || 2)");
        System.out.println("    - temp(x) POS:STAGE");
        System.out.println("    - hum(x) POS:STAGE");
        System.out.println("    - light(x) POS:STAGE");
        System.out.println("    - wind(x) POS:STAGE");
        System.out.println("    - db(x) POS:STAGE");
        System.out.println("    - move(x) POS:STAGE (x = 1.0 || 0.0)");
        System.out.println("    - activationDevice(x) POS:STAGE (x = pos of device)");
        System.out.println("    - activationSensor(x) POS:STAGE (x = pos of sensor)");
        System.out.println("    - desactivationDevice(x) POS:STAGE (x = pos of device)");
        System.out.println("    - desactivationSensor(x) POS:STAGE (x = pos of sensor)");
        System.out.println("    - EXIT\n");
        try {
            // retourne true s’il y a un autre élément dans l’entrée
            if(scanner.hasNext()){
                String res = scanner.nextLine(); //retourne la prochaine ligne complète
                interpreterConsole.interpret(res.toLowerCase());
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Retry with a valid number");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Retry with a valid command");
        }
        if(check_feature_model(house))
            retry();
        else
            System.out.println("Feature models not respected");
    }

    public void retry(){
        System.out.println("\n Would you like to modify anything else ? (Y/N)\n");
        //scanner = new scannerner(System.in); //entrée standard,peut aussi prendre un Reader ou un nom de fichier en paramètre
        try {
            if(scanner.hasNext()){
                String res = scanner.nextLine(); //retourne la prochaine ligne complète
                if(res.equals("Y")){
                    console();
                }
                else {
                    scanner.close();
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
