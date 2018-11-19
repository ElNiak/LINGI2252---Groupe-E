package device;

import other.Room;

public class Humidifier extends Device {

    public Humidifier(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "Humidifier";
        this.on = "on";
        this.off = "off";
    }

    public Humidifier(String name, double x, double y, double z, Room room) {
        super(name, x,y,z,room);
        this.on = "on";
        this.off = "off";
    }

}
