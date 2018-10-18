package device;

public class Hifi implements Device {

    private boolean state;

    public Hifi() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Hifi off");
            state = false;
            return false;
        }
        else {
            System.out.println("Hifi on");
            state = true;
            return true;
        }
    }
}
