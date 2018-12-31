package sensor;

import behavior.BehaviorStrategy;
import behavior.WindStrategy;
import other.Room;

public class WindSensor extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public WindSensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.curr = 0.0;
        this.prev = 0.0;
        this.behaviorStrategy = new BehaviorStrategy(new WindStrategy());
    }

    public WindSensor(){
        this.behaviorStrategy = new BehaviorStrategy(new WindStrategy());
    }

    @Override
    public void detect() {

        this.curr = room.getWind();
        this.prev = room.getOldwind();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            update(this.curr);
        }
    }

    @Override
    public void update(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setWind(this.curr);
    }
}
