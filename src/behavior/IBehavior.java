package behavior;

import device.Device;

import java.util.List;

public interface IBehavior {
    public void manage(double val, double oldVal, List<Device> devices);
}
