package sensor;

import other.Constants;
import other.Room;

public class LightSensor extends Sensor {

    public LightSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.curr = room.getLight();
        this.prev = room.getLight();
    }
    @Override
    public void detect() {
        this.curr = room.getLight();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
        this.prev = this.curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.LIGHT, curr);
    }

}
