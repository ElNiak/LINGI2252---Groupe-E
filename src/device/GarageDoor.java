package device;

public class GarageDoor implements Device {

    private boolean state;

    public GarageDoor() {
        this.state= false;
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("The door of the garage is down");
            state = false;
            return false;
        }
        else {
            System.out.println("The door of the garage is up");
            state = true;
            return true;
        }
    }
}
