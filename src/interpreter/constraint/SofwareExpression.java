package interpreter.constraint;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import other.House;

import java.util.ArrayList;
import java.util.List;

public class SofwareExpression extends Expression_constraint {
    private boolean inter;
    private String data;

    public SofwareExpression(boolean inter, String data){
        this.inter = inter;
        this.data = data;
    }

    @Override
    public boolean interpret(String context, JSONObject jsonObject, House house) {
        switch (context) {
            case "management_heating" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_heating");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_air_conditioning" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_air_conditioning");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_light" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_light");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_humidity" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_humidity");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_windows" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_windows");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_hifi" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_hifi");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_tv" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_tv");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_ventilation" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_ventilation");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            case "management_shutter_window" :
                if((boolean) jsonObject.get("value")){
                    JSONObject object = (JSONObject) jsonObject.get("management_shutter_window");
                    if((boolean) object.get("value")) {
                        JSONArray array = (JSONArray) jsonObject.get("constraint");
                        List<String> res = new ArrayList<>();
                        for(int i = 0; i < array.size(); i++){
                            res.add((String) array.get(i));
                        }
                        return JSONConstraint.decode_constaint(res,jsonObject,house);
                    }
                }
                return true;
            default:
                return true;
        }
    }
}
