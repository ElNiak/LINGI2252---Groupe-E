package sensor;

import behavior.BehaviorStrategy;
import behavior.HumidityStrategy;
import other.Constants;
import other.Room;

public class HumiditySensor extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public HumiditySensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.prev = 0.0;
        this.curr = 0.0;
        this.behaviorStrategy = new BehaviorStrategy(new HumidityStrategy());
    }

    public HumiditySensor(){
        this.behaviorStrategy = new BehaviorStrategy(new HumidityStrategy());
    }

    @Override
    public void detect() {
        this.curr = room.getHum();
        this.prev = room.getOldhum();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
    }

    @Override
    public void notifY(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setHum(this.curr);
    }

}
