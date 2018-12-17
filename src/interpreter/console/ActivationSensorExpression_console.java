package interpreter.console;

import other.House;
import other.Room;

import java.util.List;

public class ActivationSensorExpression_console implements Expression_console {
    private String str;
    int i;
    double add;
    int stage;
    List<Room> rooms;
    House house;

    public ActivationSensorExpression_console(String str, House house){
        this.str = str;
        this.house = house;
        try {
            add = Double.parseDouble(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
            stage = Integer.parseInt(str.substring(str.indexOf(":") + 1, str.length()));
            i = Integer.parseInt(str.substring(str.indexOf(")") + 2, str.indexOf(":")));
        }
        catch (Exception e){
            add = 0;
            i = 0;
            stage = 0;
        }
        if(stage == 1)
            rooms = house.getGround_floor();
        else
            rooms = house.getFirst_floor();
    }

    @Override
    public void interpret() {
        rooms = house.getGround_floor();
        for(int j = 0; j < rooms.size(); j++)
            rooms.get(j).activationS(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
        rooms = house.getFirst_floor();
        for(int j = 0; j < rooms.size(); j++)
            rooms.get(j).activationS(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
        System.out.println(str.substring(str.indexOf("(") + 1, str.indexOf(")")) + " are activated");
    }
}
