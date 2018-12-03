package device;

import other.Room;

public class AirConditioning extends Device {

    public AirConditioning(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.name = "Air Conditioning";
        this.on = "on";
        this.off = "off";
    }

    public AirConditioning(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "on";
        this.off = "off";
    }

}
