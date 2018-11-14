package sensor;

import other.Constants;
import other.Room;

public class PollutionSensor extends Sensor {

    public PollutionSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.curr = room.getPollution();
        this.prev = room.getPollution();
    }

    @Override
    public void detect() {
        this.curr = room.getPollution();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
        this.prev = this.curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.POLLUTION, curr);
    }

}
