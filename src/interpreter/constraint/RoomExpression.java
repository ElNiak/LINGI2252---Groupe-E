package interpreter.constraint;

import java.util.List;

public class RoomExpression extends Expression_constraint {

    public RoomExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        switch (context) {
            case "garden" :
                return interpret_interpret(context);
            case "kitchen" :
                return interpret_interpret(context);
            case "living_room" :
                return interpret_interpret(context);
            case "bedroom" :
                return interpret_interpret(context);
            case "bathroom" :
                return interpret_interpret(context);
            case "laundry_room" :
                return interpret_interpret(context);
            case "entry" :
                return interpret_interpret(context);
            case "dinning_room" :
                return interpret_interpret(context);
            case "game_room" :
                return interpret_interpret(context);
            default:
                return false;
        }
    }

    public boolean interpret_interpret(String context){
        switch (context) {
            case "mandatory" :
                return true;
            case "value" :
                return true;
            default:
                return false;
        }
    }
}
