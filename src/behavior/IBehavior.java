package behavior;

import device.Device;
import other.Room;

import java.util.List;

public interface IBehavior {
    public void manage(double val, double oldVal, Room room);
}
