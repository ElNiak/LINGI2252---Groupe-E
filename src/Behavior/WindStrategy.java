package Behavior;

import device.Device;
import device.Ventilation;
import device.Windows;

import java.util.List;

public class WindStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, List<Device> devices) {
        if(oldVal < val){ //Trop de vent
            for (Device i : devices) {
                if (i instanceof Windows) { //On
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof Ventilation) { //on
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else { //Pas assez de vent
            for (Device i : devices) {
                if (i instanceof Windows) { //On
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof Ventilation) { //off
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
