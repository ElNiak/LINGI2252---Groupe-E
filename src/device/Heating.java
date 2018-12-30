package device;

import other.Room;

public class Heating extends Device {

    public Heating(){}

    public Heating(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.name = "Heating";
        this.on = "on";
        this.off = "off";
    }

    public Heating(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "on";
        this.off = "off";
    }

}
