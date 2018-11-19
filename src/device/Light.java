package device;

import other.Room;

public class  Light  extends Device{

    public Light(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "light";
        this.on = "on";
        this.off = "off";
    }

    public Light(String name, double x, double y, double z, Room room) {
        super(name, x,y,z,room);
        this.on = "on";
        this.off = "off";
    }

}
