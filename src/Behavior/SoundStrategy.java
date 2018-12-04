package Behavior;

import device.Device;
import device.Hifi;
import device.Windows;

import java.util.List;

public class SoundStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, List<Device> devices) {
        if(oldVal < val){
            for (Device i : devices) {
                if (i instanceof Hifi) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof Windows) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else {
            for (Device i : devices) {
                if (i instanceof Hifi) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof Windows) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
