package sensor;

import other.Constants;
import other.Room;

public class LightSensor extends Sensor {

    public LightSensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.curr = 0.0;
        this.prev = 0.0;
    }

    @Override
    public void detect() {
        this.curr = room.getLight();
        this.prev = room.getOldlight();
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
