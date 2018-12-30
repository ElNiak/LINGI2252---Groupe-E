package behavior;

import device.Device;
import device.Ventilation;
import other.Room;

import java.util.List;

public class HumidityStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, Room room) {
        if(oldVal < val){ //Trop humide
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Ventilation") == 0) {
                    if (!i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
        else {
            for (Device i : room.getDevices()) {
                if (i.getName().compareTo("Ventilation") == 0) {
                    if (i.isState() && i.isActivated())
                        i.manage_device();
                }
            }
        }
    }
}
