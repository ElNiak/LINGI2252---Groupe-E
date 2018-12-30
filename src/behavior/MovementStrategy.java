package behavior;

import device.Device;
import device.Light;
import device.Tv;
import other.Room;

import java.util.List;

public class MovementStrategy implements IBehavior {
    @Override
    public void manage(double val, double oldVal, Room room) {
        if(oldVal != val){
            for (Device i : room.getDevices()){
                if (i.getName().compareTo("Light") == 0 && i.isActivated()){
                    i.manage_device();
                }
                if (i.getName().compareTo("Tv") == 0 && i.isActivated()){
                    i.manage_device();
                }
            }
        }
    }
}
