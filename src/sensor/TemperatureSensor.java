package sensor;

import behavior.BehaviorStrategy;
import behavior.SoundStrategy;
import behavior.TemperatureStrategy;
import other.Constants;
import other.Room;

public class TemperatureSensor  extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public TemperatureSensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.prev = 18.0;
        this.curr = 18.0;
        this.behaviorStrategy = new BehaviorStrategy(new TemperatureStrategy());
    }

    public TemperatureSensor(){
        this.behaviorStrategy = new BehaviorStrategy(new TemperatureStrategy());
    }

    @Override
    public void detect() {
        this.curr = room.getTemp();
        this.prev = room.getOldtemp();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
    }

    @Override
    public void notifY(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setTemp(this.curr);
    }

}
