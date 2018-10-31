package device;

import other.Room;

public class GarageDoor extends Device {

    public GarageDoor(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("The door of the garage is down");
            state = false;
            return false;
        }
        else {
            System.out.println("The door of the garage is up");
            state = true;
            return true;
        }
    }

}
