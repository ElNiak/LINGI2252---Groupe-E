package device;

import other.Room;

public class Tv extends Device {

    public Tv(double x, double y, double z, Room room) {
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
        System.out.println("TV off");
        state = false;
        return false;
    }


    public boolean start(){
        System.out.println("TV on");
        state = true;
        return true;
    }
}
