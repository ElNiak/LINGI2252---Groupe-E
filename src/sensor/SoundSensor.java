package sensor;

import behavior.BehaviorStrategy;
import behavior.PollutionStrategy;
import behavior.SoundStrategy;
import other.Constants;
import other.Room;

public class SoundSensor extends Sensor {

    BehaviorStrategy behaviorStrategy;

    public SoundSensor(double x, double y, double z, Room room, boolean activated) {
        super(x,y,z,room, activated);
        this.curr = 0.0;
        this.curr = 0.0;
        this.behaviorStrategy = new BehaviorStrategy(new SoundStrategy());
    }

    public SoundSensor(){
        this.behaviorStrategy = new BehaviorStrategy(new SoundStrategy());
    }

    @Override
    public void detect() {
        this.curr = room.getDbel();
        this.prev = room.getOlddbel();
        if(Math.abs(this.curr-this.prev) > this.lambda){
            notifY(this.curr);
        }
    }

    @Override
    public void notifY(double curr) {
        if (this.room.isActivated()){
            behaviorStrategy.manage(this.curr, this.prev, this.room);
        }
        this.room.getEnvironnement().setDbel(this.curr);
    }

}
