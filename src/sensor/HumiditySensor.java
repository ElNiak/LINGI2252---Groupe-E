package sensor;

import other.Constants;
import other.Room;

public class HumiditySensor extends Sensor {

    public HumiditySensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.prev = 0.0;
        this.curr = 0.0;
    }

    @Override
    public void detect() {
        this.curr = room.getHum();
        this.prev = room.getOldhum();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
        this.prev = this.curr;
    }

    @Override
    public void notifY(double curr) {
        this.room.getEnvironnement().update(Constants.HUM, curr);
    }

}
