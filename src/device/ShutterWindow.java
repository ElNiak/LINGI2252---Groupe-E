package device;

import other.Room;

public class ShutterWindow implements Device {

    private boolean state;
    private double x,y,z; //cm
    private Room room;

    public ShutterWindow(double x, double y, double z, Room room) {
        this.state = false; // false = off
        this.x = x; this.y = y; this.z = z;
        this.room = room;
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
