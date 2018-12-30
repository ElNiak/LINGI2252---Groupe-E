package behavior;

import device.Device;
import device.Ventilation;
import device.Windows;
import other.Room;

import java.util.List;

public class WindStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, Room room) {
        if(oldVal < val){ //Trop de vent
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Window") == 0) { //On
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("Ventilation") == 0) { //on
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else { //Pas assez de vent
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Window") == 0) { //On
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("Ventilation") == 0) { //off
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
