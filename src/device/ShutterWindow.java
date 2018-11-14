package device;

import other.Room;

public class ShutterWindow extends Device {

    public ShutterWindow(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "Shutter window";
    }

    public ShutterWindow(String name, double x, double y, double z, Room room) {
        super(name, x,y,z,room);
        this.on = "up";
        this.off = "down";
    }
}
