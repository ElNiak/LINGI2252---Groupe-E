package device;

import other.Room;

public class Humidifier extends Device {

    public Humidifier(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.name = "Humidifier";
        this.on = "on";
        this.off = "off";
    }

    public Humidifier(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "on";
        this.off = "off";
    }

}
