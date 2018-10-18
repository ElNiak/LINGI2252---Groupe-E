package device;

public class  Light  implements Device{

    private boolean state;

    public Light() {
        state = false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Light off");
            state = false;
            return false;
        }
        else {
            System.out.println("Light on");
            state = true;
            return true;
        }
    }
}
