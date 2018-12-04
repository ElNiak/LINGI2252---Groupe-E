package Behavior;

import device.Device;
import device.Light;
import device.Tv;

import java.util.List;

public class MovementStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, List<Device> devices) {
        if(oldVal != val){
            for (Device i : devices){
                if (i instanceof Light && i.isActivated()){
                    i.manage_device();
                }
                if (i instanceof Tv && i.isActivated()){
                    i.manage_device();
                }
            }
        }
    }
}
