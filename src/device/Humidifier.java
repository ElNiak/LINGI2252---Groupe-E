package device;

import other.Room;

public class Humidifier extends Device {

    public Humidifier(double x, double y, double z, Room room) {
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
        System.out.println("Humidifier off");
        state = false;
        return false;
    }


    public boolean start(){
        System.out.println("Humidifier on");
        state = true;
        return true;
    }
}
