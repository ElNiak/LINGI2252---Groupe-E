package device;

import other.Room;

public class Heating extends Device {

    public Heating(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Heating off");
            state = false;
            return false;
        }
        else {
            System.out.println("Heating on");
            state = true;
            return true;
        }
    }

}
