package behavior;

import device.Device;
import device.Light;
import device.ShutterWindow;
import other.Room;

import java.util.List;

public class LightStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, Room room) {
        if(oldVal < val){ //Trop lumineux
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Light") == 0) { //On ferme les lampe
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("ShutterWindow") == 0) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else {
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Light") == 0) { //On ferme les lampe
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
                if (i.getName().compareTo("ShutterWindow") == 0) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }

}
