import device.Heating;
import other.House;

import java.util.Scanner;

public class SpecificParametrisation extends Parametrisation{

    public SpecificParametrisation(Scanner scanner) {
        super(scanner);
    }

    public House create_house(String json){
        if(check_feature_model())
            return House.getInstance();
        else {
            System.out.println("Feature model not respected");
            return null;
        }
    }
}
