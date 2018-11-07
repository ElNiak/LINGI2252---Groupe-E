package device;

import other.Room;

public class GarageDoor extends Device {

    public GarageDoor(double x, double y, double z, Room room) {
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
        System.out.println("The door of the garage is down");
        state = false;
        return false;
    }


    public boolean start(){
        System.out.println("The door of the garage is up");
        state = true;
        return true;
    }

}
