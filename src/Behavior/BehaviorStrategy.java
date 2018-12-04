package Behavior;

import device.Device;

import java.util.List;

public class BehaviorStrategy {
    IBehavior behavior;

    public BehaviorStrategy(){

    }

    public BehaviorStrategy(IBehavior behavior){
        this.behavior = behavior;
    }

    public void setBehavior(IBehavior behavior) {
        this.behavior = behavior;
    }

    public IBehavior getBehavior() {
        return behavior;
    }

    public void manage(double val, double oldVal, List<Device> devices){
        behavior.manage(val, oldVal, devices);
    }
}
