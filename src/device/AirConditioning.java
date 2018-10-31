package device;

import other.Room;

public class AirConditioning extends Device {

    public AirConditioning(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Air conditioning off");
            state = false;
            return  false;
        }
        else {
            System.out.println("Air conditioning on");
            state = true;
            return true;
        }
    }

}
