package sensor;

import behavior.BehaviorStrategy;
import behavior.MovementStrategy;
import behavior.PollutionStrategy;
import other.Constants;
import other.Room;

public class PollutionSensor extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public PollutionSensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.curr = 0.0;
        this.prev = 0.0;
        this.behaviorStrategy = new BehaviorStrategy(new PollutionStrategy());
    }

    public PollutionSensor(){
        this.behaviorStrategy = new BehaviorStrategy(new PollutionStrategy());
    }

    @Override
    public void detect() {
        this.curr = room.getPollution();
        this.prev = room.getOldpollution();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
    }

    @Override
    public void notifY(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setPollution(this.curr);
    }

}
