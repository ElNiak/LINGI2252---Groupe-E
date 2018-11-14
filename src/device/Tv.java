package device;

import other.Room;

public class Tv extends Device {

    public Tv(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "Tv";
    }

    public Tv(String name, double x, double y, double z, Room room) {
        super(name,x,y,z,room);
    }
}
