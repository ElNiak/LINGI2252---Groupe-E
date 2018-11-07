package device;

import other.Room;

public class ShutterWindow extends Device {

    public ShutterWindow(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }
    @Override
    public boolean manage_device() {
        if (state) {
            return stop();
        }
        else {
            return start();
        }
    }

    public boolean stop(){
        System.out.println("Shutters down");
        state = false;
        return false;
    }


    public boolean start() {
        System.out.println("Shutters up");
        state = true;
        return true;
    }
}
