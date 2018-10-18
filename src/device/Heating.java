package device;

public class Heating implements Device {

    private boolean state;

    public Heating() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Heating off");
            state = false;
            return false;
        }
        else {
            System.out.println("Heating on");
            state = true;
            return true;
        }
    }
}
