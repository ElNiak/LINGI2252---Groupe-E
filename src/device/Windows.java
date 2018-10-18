package device;

public class Windows implements Device {

    private boolean state;

    public Windows() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Windows down");
            state = false;
            return false;
        }
        else {
            System.out.println("Windows up");
            state = true;
            return true;
        }
    }
}
