package behavior;

import device.Device;
import device.Ventilation;

import java.util.List;

public class HumidityStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, List<Device> devices) {
        if(oldVal < val){ //Trop humide
            for (Device i : devices) {
                if (i instanceof Ventilation) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else {
            for (Device i : devices) {
                if (i instanceof Ventilation) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
