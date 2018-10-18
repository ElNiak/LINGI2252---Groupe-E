package device;

public class Ventillation implements Device {

    private boolean state;

    public Ventillation() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Ventillation off");
            state = false;
            return false;
        }
        else {
            System.out.println("Ventillation on");
            state = true;
            return true;
        }
    }
}
