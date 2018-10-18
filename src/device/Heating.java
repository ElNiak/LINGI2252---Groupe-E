package device;

import other.Room;

public class Heating implements Device {

    private boolean state;
    private double x,y,z; //cm
    private Room room;

    public Heating(double x, double y, double z, Room room) {
        this.state = false; // false = off
        this.x = x; this.y = y; this.z = z;
        this.room = room;
    }

    @Override
    public boolean start() {
        if (state) {
            System.out.println("Heating off");
            state = false;
            return false;
        }
        else {
            System.out.println("Heating on");
            state = true;
            return true;
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
