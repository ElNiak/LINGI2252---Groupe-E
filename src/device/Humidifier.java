package device;

public class Humidifier implements Device {

    private boolean state;

    public Humidifier() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Humidifier off");
            state = false;
            return false;
        }
        else {
            System.out.println("Humidifier on");
            state = true;
            return true;
        }
    }
}
