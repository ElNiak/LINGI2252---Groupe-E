package behavior;

import device.AirConditioning;
import device.Device;
import device.Heating;
import device.Windows;

import java.util.List;

public class TemperatureStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, List<Device> devices) {
        if(oldVal < val) { //Trop chaud
            for (Device i : devices) {
                if (i instanceof AirConditioning) { //Start la clim
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof Heating) { //Stop radia si allumer
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof Windows) { //Start clim
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else { //Trop froid
            for (Device i : devices) {
                if (i instanceof Heating) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device(); //Start le radiateur
                }
                if (i instanceof AirConditioning) { //Stop la clim
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof Windows) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
