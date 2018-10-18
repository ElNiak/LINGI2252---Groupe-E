package sensor;

public class Camera implements Sensor {

    public Camera() {
    }

    @Override
    public double detect(String type) {
        System.out.println("");
        return 0;
    }

    @Override
    public void notifY() {

    }

    @Override
    public double attach(Object o) {
        return 0;
    }

    @Override
    public double detach(Object o) {
        return 0;
    }
}
