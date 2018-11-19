package device;

import other.Room;

public class Heating extends Device {

    public Heating(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "Heating";
        this.on = "on";
        this.off = "off";
    }

    public Heating(String name, double x, double y, double z, Room room) {
        super(name,x,y,z,room);
        this.on = "on";
        this.off = "off";
    }

}
