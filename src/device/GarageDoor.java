package device;

import other.Room;

public class GarageDoor extends Device {

    public GarageDoor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.name = "Garage door";
        this.on = "up";
        this.off = "down";
    }

    public GarageDoor(String name, double x, double y, double z, Room room){
        super(name, x, y, z, room);
        this.on = "up";
        this.off = "down";
    }

}
