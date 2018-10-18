package device;

public class AirConditioning implements Device {

    private boolean state;

    public AirConditioning() {
        this.state = false; // false = off
    }

    @Override
    public boolean start(String id) {
        if (state) {
            System.out.println("Air conditioning off");
            state = false;
            return  false;
        }
        else {
            System.out.println("Air conditioning on");
            state = true;
            return true;
        }
    }
}
