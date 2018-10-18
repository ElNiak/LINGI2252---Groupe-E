package device;

public class ShutterWindow implements Device {

    private boolean state;

    public ShutterWindow() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Shutters down");
            state = false;
            return false;
        }
        else {
            System.out.println("Shutters up");
            state = true;
            return true;
        }
    }
}
