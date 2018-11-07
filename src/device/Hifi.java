package device;

import other.Room;

public class Hifi extends Device {

    public Hifi(double x, double y, double z, Room room) {
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
        System.out.println("Hifi off");
        state = false;
        return false;
    }


    public boolean start(){
        System.out.println("Hifi on");
        state = true;
        return true;
    }

}
