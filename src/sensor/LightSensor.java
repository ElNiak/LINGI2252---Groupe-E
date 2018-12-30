package sensor;

import behavior.BehaviorStrategy;
import behavior.LightStrategy;
import other.Constants;
import other.Room;

public class LightSensor extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public LightSensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.curr = 0.0;
        this.prev = 0.0;
        this.behaviorStrategy = new BehaviorStrategy(new LightStrategy());
    }

    public LightSensor(){
        this.behaviorStrategy = new BehaviorStrategy(new LightStrategy());
    }

    @Override
    public void detect() {
        this.curr = room.getLight();
        this.prev = room.getOldlight();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
    }

    @Override
    public void notifY(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setLight(this.curr);
    }

}
