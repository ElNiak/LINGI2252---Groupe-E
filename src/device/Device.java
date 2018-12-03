package device;

import other.Room;

public abstract class Device {

    protected boolean state;
    protected double x,y,z; //cm
    protected Room room;
    protected String name;
    protected String on;
    protected String off;
    protected boolean activated;


    public Device(String name, double x, double y, double z, Room room, boolean activated) {
        this.state = false; // false = off
        this.x = x; this.y = y; this.z = z;
        this.room = room;
        this.name = name;
        this.on = "on";
        this.off = "off";
        this.activated = activated;
    }


    public Device(double x, double y, double z, Room room, boolean activated) {
        this.state = false; // false = off
        this.x = x; this.y = y; this.z = z;
        this.room = room;
        this.activated = activated;
    }


    /**
     * @pre
     * @post
     */
    public boolean manage_device(){
        if (state) {
            return stop();
        }
        else {
            return start();
        }
    }

    public boolean stop(){
        System.out.println(this.name + " " + this.off);
        state = false;
        return true;
    }

    public boolean start(){
        System.out.println(this.name + " " + this.on);
        state = true;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
