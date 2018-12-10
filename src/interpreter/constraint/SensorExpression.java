package interpreter.constraint;

import java.util.List;

public class SensorExpression extends Expression_constraint {
    private boolean inter;
    private String data;

    public SensorExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        switch (context) {
            case "humidity" :
                return true;
            case "light" :
                return true;
            case "temperature" :
                return true;
            case "pollution" :
                return true;
            case "wind" :
                return true;
            case "sonore" :
                return true;
            case "movement" :
                return true;
            case "camera" :
                return true;
            default:
                return true;
        }
    }
}
