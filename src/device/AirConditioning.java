package device;

import other.Room;

public class AirConditioning extends Device {

    public AirConditioning(double x, double y, double z, Room room) {
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
        System.out.println("Air conditioning off");
        state = false;
        return  false;
    }


    public boolean start(){
        System.out.println("Air conditioning on");
        state = true;
        return true;
    }

}
