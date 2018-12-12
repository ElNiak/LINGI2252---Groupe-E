package interpreter.constraint;

import org.json.simple.JSONObject;
import other.House;
import sensor.HumiditySensor;
import sensor.Sensor;

import java.util.List;

public class SensorExpression extends Expression_constraint {
    private boolean inter;
    private String data;

    public SensorExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public boolean interpret(String context, JSONObject jsonObject, House house) {
        switch (context) {
            case "humidity" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            case "light" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            case "temperature" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            case "pollution" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            case "wind" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            case "sonore" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            case "movement" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            case "camera" :
                if((boolean) jsonObject.get("value")){
                    return house.containS(context);
                }
                return true;
            default:
                return true;
        }
    }
}
