package sensor;

import other.Constants;
import other.Room;

public class Camera extends Sensor {


    public Camera(double x, double y, double z,  Room room) {
        super(x,y,z,room);
        this.curr = 0.0;
    }

    @Override
    public void detect() {
        this.curr = room.isMovement();
        this.prev = room.isOldmovement();
        if(curr == prev){
            notifY(1.0);
        }
        else{
            notifY(0.0);
        }
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.MOVEMENT, curr);
    }

}
