package sensor;

import other.Constants;
import other.Room;

public class PollutionSensor extends Sensor {

    public PollutionSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
    }

    @Override
    public void detect() {
        curr = Math.random()*1000 % 20;
        if(Math.abs(curr-prev) > lambda){
            notifY(curr);
        }
        prev = curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.POLLUTION, curr);
    }

}
