package device;

import other.Room;

public class AirConditioning extends Device {

    public AirConditioning(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    public AirConditioning(String name, double x, double y, double z, Room room){
        super(name, x, y, z, room);
    }

}
