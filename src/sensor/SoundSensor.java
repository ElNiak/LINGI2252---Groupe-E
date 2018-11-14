package sensor;

import other.Constants;
import other.Room;

public class SoundSensor extends Sensor {

    public SoundSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.curr = room.getDbel();
        this.curr = room.getDbel();
    }
    @Override
    public void detect() {
        this.curr = room.getDbel();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
        this.prev = this.curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.DBEL, curr);
    }

}
