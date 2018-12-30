package behavior;

import device.Device;
import device.Hifi;
import device.Windows;
import other.Room;

import java.util.List;

public class SoundStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, Room room) {
        if(oldVal < val){
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Hifi") == 0) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("Window") == 0) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else {
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Hifi") == 0) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("Window") == 0) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
