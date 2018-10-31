package device;

import other.Room;

public class ShutterWindow extends Device {

    public ShutterWindow(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }
    @Override
    public boolean start() {
        if (state) {
            System.out.println("Shutters down");
            state = false;
            return false;
        }
        else {
            System.out.println("Shutters up");
            state = true;
            return true;
        }
    }
}
