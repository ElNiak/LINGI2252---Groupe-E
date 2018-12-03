package device;

import other.Room;

public class  Light  extends Device{

    public Light(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.name = "light";
        this.on = "on";
        this.off = "off";
    }

    public Light(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "on";
        this.off = "off";
    }

}
