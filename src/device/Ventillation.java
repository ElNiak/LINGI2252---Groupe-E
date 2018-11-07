package device;

import other.Room;

public class Ventillation extends Device {

    public Ventillation(double x, double y, double z, Room room) {
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
        System.out.println("Ventillation off");
        state = false;
        return false;
    }


    public boolean start(){
        System.out.println("Ventillation on");
        state = true;
        return true;
    }
}
