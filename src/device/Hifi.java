package device;

import other.Room;

public class Hifi extends Device {

    public Hifi(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "Hifi";
    }

    public Hifi(String name, double x, double y, double z, Room room) {
        super(name,x,y,z,room);
    }


}
