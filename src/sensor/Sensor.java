package sensor;

import other.Room;

public abstract class Sensor {
    protected double x,y,z; //cm
    protected double prev, curr;
    protected double lambda = 0.1;
    protected Room room;
    protected boolean activated;

    public Sensor(double x, double y, double z, Room room, boolean activated) {
        this.x = x; this.y = y; this.z = z;
        this.prev = 0.0;
        this.curr = 0.0;
        this.room = room;
        this.activated = activated;
    }

    public Sensor(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.room = null;
        this.activated = true;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    /**
     * @pre
     * @post
     */
    public void detect(){

    }

    /**
     * @pre
     * @post
     */
    public void notifY(double current){

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

    public double getPrev() {
        return prev;
    }

    public void setPrev(double prev) {
        this.prev = prev;
    }

    public double getCurr() {
        return curr;
    }

    public void setCurr(double curr) {
        this.curr = curr;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
