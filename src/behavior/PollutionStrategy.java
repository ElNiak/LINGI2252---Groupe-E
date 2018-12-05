package behavior;

import device.Device;
import device.Windows;

import java.util.List;

public class PollutionStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, List<Device> devices) {
        if(oldVal < val){ //Trop pollution
            for (Device i : devices) {
                if (i instanceof Windows) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else {
            for (Device i : devices) {
                if (i instanceof Windows) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }

}
