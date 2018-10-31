package sensor;

import other.Constants;
import other.Room;

public class Camera extends Sensor {

    public Camera(double x, double y, double z,  Room room) {
        super(x,y,z,room);
    }

    @Override
    public void detect() {
        curr = Math.random()*1000 % 20; //Still random now
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
