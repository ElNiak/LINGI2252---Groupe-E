package device;

import other.Room;

public class Hifi extends Device {

    public Hifi(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Hifi off");
            state = false;
            return false;
        }
        else {
            System.out.println("Hifi on");
            state = true;
            return true;
        }
    }

}
