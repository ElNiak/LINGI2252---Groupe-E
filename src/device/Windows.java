package device;

import other.Room;

public class Windows extends Device {

    private boolean state;
    private double x,y,z; //cm
    private Room room;

    public Windows(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Windows down");
            state = false;
            return false;
        }
        else {
            System.out.println("Windows up");
            state = true;
            return true;
        }
    }
}
