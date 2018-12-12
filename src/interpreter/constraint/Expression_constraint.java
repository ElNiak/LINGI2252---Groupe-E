package interpreter.constraint;

import org.json.simple.JSONObject;
import other.House;

import java.util.List;

public abstract class Expression_constraint {
    protected boolean inter = false;
    protected String data = null;

    public boolean interpret(String context, JSONObject jsonObject, House house){
        return true;
    }
}
