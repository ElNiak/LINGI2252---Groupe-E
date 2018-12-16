import interpreter.console.InterpreterConsole;
import interpreter.constraint.JSONConstraint;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import other.House;
import sensor.*;

import java.io.FileReader;
import java.io.IOException;
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
        JSONConstraint.decode_constraint(System.getProperty("user.dir") + "/src/res/feature_model.json",house);
        try{
            Object o1 = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + "/src/res/feature_model.json"));
            JSONObject j = (JSONObject) o1;
            JSONObject jo = (JSONObject) j.get("house_automation");
            if((boolean) jo.get("value")) {
                retry();
            } else {
                System.out.println("Feature models not respected");
                System.exit(-1);
            }
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }
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
