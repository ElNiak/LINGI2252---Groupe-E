import device.Heating;
import other.House;

import java.util.Scanner;

public class SpecificParametrisation extends Parametrisation{

    public SpecificParametrisation(Scanner scanner) {
        super(scanner);
    }

    public House create_house(String json){
        return House.getInstance();
    }
}
