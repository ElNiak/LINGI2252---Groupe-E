import other.House;
import sensor.*;

public class Parametrisation {

    public static boolean check_feature_model(String json){
        House house = new House(json);
        return check_feature_model(house);
    }

    public static boolean check_feature_model(House house){
        if(house.getGround_floor() == null)
            return false;
        if(house.getFirst_floor() == null)
            return false;

        boolean kitchen=false, living=false, bed=false, bath=false, temp=false, light=false, mvt=false, camera=false;
        for(int i = 0; i < house.getGround_floor().size(); i++){
            if(house.getGround_floor().get(i).getName().equals("Kitchen"))
                kitchen = true;
            if(house.getGround_floor().get(i).getName().equals("LivingRoom"))
                living = true;
            if(house.getGround_floor().get(i).getName().equals("BedRoom"))
                bed = true;
            if(house.getGround_floor().get(i).getName().equals("BathRoom"))
                bath = true;

            for(Sensor s:house.getGround_floor().get(i).getSensors()) {
                if(s instanceof TemperatureSensor && s.isActivated())
                    temp = true;
                if(s instanceof LightSensor && s.isActivated())
                    light = true;
                if(s instanceof Camera && s.isActivated())
                    camera = true;
                if(s instanceof MovementSensor && s.isActivated())
                    mvt = true;
            }

        }

        for(int i = 0; i < house.getFirst_floor().size(); i++){
            if(house.getFirst_floor().get(i).getName().equals("Kitchen"))
                kitchen = true;
            if(house.getFirst_floor().get(i).getName().equals("LivingRoom"))
                living = true;
            if(house.getFirst_floor().get(i).getName().equals("BedRoom"))
                bed = true;
            if(house.getFirst_floor().get(i).getName().equals("BathRoom"))
                bath = true;

            for(Sensor s:house.getFirst_floor().get(i).getSensors()) {
                if(s instanceof TemperatureSensor && s.isActivated())
                    temp = true;
                if(s instanceof LightSensor && s.isActivated())
                    light = true;
                if(s instanceof Camera && s.isActivated())
                    camera = true;
                if(s instanceof MovementSensor && s.isActivated())
                    mvt = true;
            }
        }
        return kitchen && light && living && bed && bath && temp && mvt && camera;
    }
}
