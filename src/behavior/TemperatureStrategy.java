package behavior;

import device.AirConditioning;
import device.Device;
import device.Heating;
import device.Windows;
import other.Room;

import java.util.List;

public class TemperatureStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, Room room) {
        if(oldVal < val) { //Trop chaud
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("AirConditioning") == 0) { //Start la clim
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("Heating") == 0) { //Stop radia si allumer
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("Window") == 0) { //Start clim
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else { //Trop froid
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Heating") == 0) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device(); //Start le radiateur
                }
                if (i.getName().compareTo("AirConditioning") == 0) { //Stop la clim
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("Window") == 0) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
