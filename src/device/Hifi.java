package device;

import other.Room;

public class Hifi extends Device {

    public Hifi(){}

    public Hifi(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.name = "Hifi";
        this.on = "on";
        this.off = "off";
    }

    public Hifi(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "on";
        this.off = "off";
    }


}
