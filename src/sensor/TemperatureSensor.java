package sensor;

import other.Constants;
import other.Room;

public class TemperatureSensor  extends Sensor {

    public TemperatureSensor(double x, double y, double z, Room room) {
        super(x,y,z,room);
        this.prev = 18.0;
        this.curr = 18.0;
    }
    @Override
    public void detect() {
        this.curr = room.getTemp();
        this.prev = room.getOldtemp();
        //System.out.println("(1) oldtemp = " + prev + " + temp = " + curr);
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
