package sensor;

import behavior.BehaviorStrategy;
import behavior.MovementStrategy;
import other.Constants;
import other.Room;

public class MovementSensor extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public MovementSensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.curr = 0.0;
        this.behaviorStrategy = new BehaviorStrategy(new MovementStrategy());
    }

    public MovementSensor(){
        this.behaviorStrategy = new BehaviorStrategy(new MovementStrategy());
    }

    @Override
    public void detect() {
        this.curr = room.isMovement();
        this.prev = room.isOldmovement();
        notifY(curr);
    }

    @Override
    public void notifY(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setMovement(this.curr);
    }

}
