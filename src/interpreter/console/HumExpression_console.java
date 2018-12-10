package interpreter.console;

import other.House;
import other.Room;

import java.util.List;

public class HumExpression_console implements Expression_console {

    private String str;
    int i;
    double add;
    int stage;
    List<Room> rooms;

    public HumExpression_console(String str, House house){
        this.str = str;
        i = Integer.parseInt(str.substring(str.indexOf(")") + 2, str.indexOf(":")));
        add = Double.parseDouble(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
        stage = Integer.parseInt(str.substring(str.indexOf(":") + 1, str.length()));
        if(stage == 1)
            rooms = house.getGround_floor();
        else
            rooms = house.getFirst_floor();
    }

    @Override
    public void interpret() {
        System.out.println("\n" + "Before : Environnement = " +rooms.get(i).getEnvironnement().toString());
        rooms.get(i).setHum(rooms.get(i).getHum() + add);
        System.out.println("After : Environnement = " +rooms.get(i).getEnvironnement().toString() + "\n");
    }
}
