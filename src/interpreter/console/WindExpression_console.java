package interpreter.console;

import interpreter.console.Expression_console;
import other.House;
import other.Room;

import java.util.List;

public class WindExpression_console implements Expression_console {
    private String str;
    int i;
    double add;
    int stage;
    List<Room> rooms;

    public WindExpression_console(String str, House house){
        this.str = str;
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
        System.out.println("\n" + "Before : Environnement = " +rooms.get(i).getEnvironnement().toString());
        rooms.get(i).setWind(rooms.get(i).getWind() + add);
        System.out.println("After : Environnement = " +rooms.get(i).getEnvironnement().toString() + "\n");
    }
}
