package interpreter.constraint;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import other.House;

import java.util.ArrayList;
import java.util.List;

public class SofwareExpression extends Expression_constraint {

    public SofwareExpression(){

    }

    @Override
    public boolean interpret(String context, JSONObject jsonObject, House house) {
        JSONObject object = (JSONObject) jsonObject.get(context);
        JSONArray array = (JSONArray) object.get("constraint");
        List<String> res = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            res.add((String) array.get(i));
        }
        if(JSONConstraint.decode_constaint(res,jsonObject,house)){
            JSONConstraint.modify_json(1,context,true);
            return true;
        }
        else {
            JSONConstraint.modify_json(1,context,false);
            return false;
        }
    }
}
