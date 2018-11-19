package sensor;

import other.Constants;
import other.Room;

public class MovementSensor extends Sensor {

    private boolean curr;

    public MovementSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.curr = false;
    }
    @Override
    public void detect() {
        this.curr = room.isMovement();
        if(curr){
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
