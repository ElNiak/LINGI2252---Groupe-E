package interpreter.constraint;

import org.json.simple.JSONObject;
import other.House;

import java.util.List;

public class RoomExpression extends Expression_constraint {

    public RoomExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public boolean interpret(String context, JSONObject jsonObject, House house) {
        switch (context) {
            case "garden" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("garden");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "kitchen" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("kitchen");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "living_room" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("living_room");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "bedroom" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("bedroom");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "bathroom" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("bathroom");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "laundry_room" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("laundry_room");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "entry" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("entry");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "dinning_room" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("dinning_room");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            case "game_room" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("game_room");
                    if((boolean) object.get("value")) {
                        if((boolean) object.get("mandatory"))
                            return house.containR(context,true);
                        else
                            return house.containR(context,false);
                    }
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

}
