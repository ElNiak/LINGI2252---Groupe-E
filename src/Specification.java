import device.Heating;
import other.House;

public class Specification {

    public static House create_house(String json){
        if(Parametrisation.check_feature_model(json))
            return House.getInstance();
        else {
            System.out.println("Feature model not respected");
            return null;
        }
    }
}
