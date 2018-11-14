package sensor;

import other.Constants;
import other.Room;

public class HumiditySensor extends Sensor {

    public HumiditySensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.prev = room.getHum();
        this.curr = room.getHum();
    }

    @Override
    public void detect() {
        this.curr = room.getHum();
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
