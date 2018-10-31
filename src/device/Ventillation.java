package device;

import other.Room;

public class Ventillation extends Device {

    public Ventillation(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Ventillation off");
            state = false;
            return false;
        }
        else {
            System.out.println("Ventillation on");
            state = true;
            return true;
        }
    }
}
