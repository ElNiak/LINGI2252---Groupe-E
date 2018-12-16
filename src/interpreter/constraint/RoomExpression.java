package interpreter.constraint;

import org.json.simple.JSONObject;
import other.House;

import java.util.List;

public class RoomExpression extends Expression_constraint {

    public RoomExpression(){
    }

    @Override
    public boolean interpret(String context, JSONObject jsonObject, House house) {
        JSONObject object = (JSONObject) jsonObject.get(context);
        if((boolean) object.get("mandatory")) {
            if(house.containR(context)){
                JSONConstraint.modify_json(3,context,true);
                return true;
            }
            else {
                JSONConstraint.modify_json(3,context,false);
                return false;
            }
        }
        return true;
    }

}
