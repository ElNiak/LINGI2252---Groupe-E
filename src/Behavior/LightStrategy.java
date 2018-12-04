package Behavior;

import device.Device;
import device.Light;
import device.ShutterWindow;

import java.util.List;

public class LightStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, List<Device> devices) {
        if(oldVal < val){ //Trop lumineux
            for (Device i : devices) {
                if (i instanceof Light) { //On ferme les lampe
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof ShutterWindow) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else {
            for (Device i : devices) {
                if (i instanceof Light) { //On ferme les lampe
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i instanceof ShutterWindow) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }

}
