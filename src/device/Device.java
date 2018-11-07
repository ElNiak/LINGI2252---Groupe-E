package device;

import other.Room;

public abstract class Device {

    protected boolean state;
    protected double x,y,z; //cm
    protected Room room;

    public Device(double x, double y, double z, Room room) {
        this.state = false; // false = off
        this.x = x; this.y = y; this.z = z;
        this.room = room;
    }


    /**
     * @pre
     * @post
     */
    public boolean manage_device(){
        return false;
    }

    public boolean stop(){
        return true;
    }

    public boolean start(){
        return true;
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
