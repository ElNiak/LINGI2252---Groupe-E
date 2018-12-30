package device;

import other.Room;

public class Tv extends Device {

    public Tv() {
    }

    public Tv(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.name = "Tv";
        this.on = "on";
        this.off = "off";
    }

    public Tv(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "on";
        this.off = "off";
    }
}
