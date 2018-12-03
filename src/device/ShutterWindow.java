package device;

import other.Room;

public class ShutterWindow extends Device {

    public ShutterWindow(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.name = "Shutter window";
        this.on = "up";
        this.off = "down";
    }

    public ShutterWindow(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "up";
        this.off = "down";
    }
}
