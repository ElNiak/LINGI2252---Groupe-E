package device;

import other.Room;

public class Windows extends Device {

    public Windows(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.on = "up";
        this.off = "down";
        this.name = "Window";
    }

    public Windows(String name, double x, double y, double z, Room room) {
        super(name, x,y,z,room);
        this.on = "up";
        this.off = "down";
    }

}
