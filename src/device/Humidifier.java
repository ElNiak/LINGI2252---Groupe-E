package device;

import other.Room;

public class Humidifier extends Device {

    public Humidifier(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Humidifier off");
            state = false;
            return false;
        }
        else {
            System.out.println("Humidifier on");
            state = true;
            return true;
        }
    }
}
