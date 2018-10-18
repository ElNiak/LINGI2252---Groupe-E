package sensor;

import other.Constants;
import other.Room;

public class MovementSensor implements Sensor {
    private double x,y,z; //cm
    private double prev, curr;
    private double lambda = 0.1;
    private Room room;

    public MovementSensor(double x, double y, double z, Room room) {
        this.x = x; this.y = y; this.z = z;
        prev = 0.0;
        curr = 0.0;
        this.room = room;
    }
    @Override
    public void detect() {
        curr = Math.random()*1000 % 20;
        if(Math.abs(curr-prev) > lambda){
            notifY(1.0);
        }
        else{
            notifY(0.0);
        }
        prev = curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.MOVEMENT, curr);
    }

}
