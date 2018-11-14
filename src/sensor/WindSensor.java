package sensor;

import other.Constants;
import other.Room;

public class WindSensor extends Sensor {

    public WindSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.curr = room.getWind();
        this.prev = room.getWind();
    }
    @Override
    public void detect() {
        this.curr = room.getWind();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
        this.prev = this.curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.WIND, curr);
    }
}
