package device;

public class Tv implements Device {

    private boolean state;

    public Tv() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("TV off");
            state = false;
            return false;
        }
        else {
            System.out.println("TV on");
            state = true;
            return true;
        }
    }
}
