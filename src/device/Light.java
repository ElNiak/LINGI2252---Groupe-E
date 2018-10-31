package device;

import other.Room;

public class  Light  extends Device{

    public Light(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Light off");
            state = false;
            return false;
        }
        else {
            System.out.println("Light on");
            state = true;
            return true;
        }
    }
}
