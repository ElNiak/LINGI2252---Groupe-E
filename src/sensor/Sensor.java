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

}
