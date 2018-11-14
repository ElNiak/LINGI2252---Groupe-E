package sensor;

import other.Constants;
import other.Room;

public class TemperatureSensor  extends Sensor {

    public TemperatureSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.prev = room.getTemp();
        this.curr = room.getTemp();
    }
    @Override
    public void detect() {
        this.curr = room.getTemp();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
        this.prev = this.curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.TEMP, curr);
    }

}
