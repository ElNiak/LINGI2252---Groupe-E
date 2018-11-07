package device;

import other.Room;

public class  Light  extends Device{

    public Light(double x, double y, double z, Room room) {
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
        System.out.println("Light off");
        state = false;
        return false;
    }


    public boolean start(){
        System.out.println("Light on");
        state = true;
        return true;
    }
}
