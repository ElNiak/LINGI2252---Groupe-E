package interpreter.constraint;

import java.util.List;

public class SofwareExpression extends Expression_constraint {
    private boolean inter;
    private String data;

    public SofwareExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        switch (context) {
            case "management_heating" :
                return interpret_interpret(context);
            case "management_air_conditioning" :
                return interpret_interpret(context);
            case "management_light" :
                return interpret_interpret(context);
            case "management_humidity" :
                return interpret_interpret(context);
            case "management_windows" :
                return interpret_interpret(context);
            case "management_hifi" :
                return interpret_interpret(context);
            case "management_tv" :
                return interpret_interpret(context);
            case "management_ventilation" :
                return interpret_interpret(context);
            case "management_shutter_window" :
                return interpret_interpret(context);
            default:
                return true;
        }
    }

    public boolean interpret_interpret(String context){
        switch (context) {
            case "constraint" :
                return true;
            case "value" :
                return true;
            default:
                return false;
        }
    }
}
