package device;

import other.Room;

public class Humidifier implements Device {

    private boolean state;
    private double x,y,z; //cm
    private Room room;

    public Humidifier(double x, double y, double z, Room room) {
        this.state = false; // false = off
        this.x = x; this.y = y; this.z = z;
        this.room = room;
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Humidifier off");
            state = false;
            return false;
        }
        else {
            System.out.println("Humidifier on");
            state = true;
            return true;
        }
    }
}
