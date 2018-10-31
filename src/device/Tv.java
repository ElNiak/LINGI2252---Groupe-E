package device;

import other.Room;

public class Tv extends Device {

    public Tv(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("TV off");
            state = false;
            return false;
        }
        else {
            System.out.println("TV on");
            state = true;
            return true;
        }
    }
}
