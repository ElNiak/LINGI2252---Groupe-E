package device;

import other.Room;

public class Ventilation extends Device {

    public Ventilation(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "Ventilation";
        this.on = "on";
        this.off = "off";
    }

    public Ventilation(String name, double x, double y, double z, Room room) {
        super(name, x,y,z,room);
        this.on = "on";
        this.off = "off";
    }

}
