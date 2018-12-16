package interpreter.constraint;

import org.json.simple.JSONObject;
import other.House;
import sensor.HumiditySensor;
import sensor.Sensor;

import java.util.List;

public class SensorExpression extends Expression_constraint {
    private boolean inter;
    private String data;

    public SensorExpression(){

    }

    @Override
    public boolean interpret(String context, JSONObject jsonObject, House house) {
        if(house.containS(context)){
            JSONConstraint.modify_json(2,context,true);
            return true;
        }
        else {
            JSONConstraint.modify_json(2,context,false);
            return false;
        }
    }
}
