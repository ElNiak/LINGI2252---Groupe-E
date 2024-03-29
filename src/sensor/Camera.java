package sensor;

import behavior.BehaviorStrategy;
import behavior.MovementStrategy;
import other.Room;

public class Camera extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public Camera(double x, double y, double z,  Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.curr = 0.0;
        this.behaviorStrategy = new BehaviorStrategy(new MovementStrategy());
    }

    public Camera(){
        this.behaviorStrategy = new BehaviorStrategy(new MovementStrategy());
    }

    @Override
    public void detect() {
        this.curr = room.isMovement();
        this.prev = room.isOldmovement();
        if(curr == prev){
            update(1.0);
        }
        else{
            update(0.0);
        }
    }

    @Override
    public void update(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setMovement(this.curr);
    }

}
