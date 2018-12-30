package device;

import other.Room;

public class Windows extends Device {

    public Windows() {
    }

    public Windows(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.on = "up";
        this.off = "down";
        this.name = "Window";
    }

    public Windows(String name, double x, double y, double z, Room room, boolean activated){
        super(name, x, y, z, room, activated);
        this.on = "up";
        this.off = "down";
    }

}
