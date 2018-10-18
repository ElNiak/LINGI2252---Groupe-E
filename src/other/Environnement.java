package other;

public class Environnement {

    private double temp;
    private double hum;
    private double light;
    private double wind;
    private double pressure;
    private double db;

    public Environnement() {
    }

    public Environnement(double temp, double hum, double light, double wind, double pressure, double db) {
        this.temp = temp;
        this.hum = hum;
        this.light = light;
        this.wind = wind;
        this.pressure = pressure;
        this.db = db;
    }

    /**
     * @pre
     * @post
     */
    public Environnement update() {
        return new Environnement();
    }

    @Override
    public String toString() {
        return "Environnement{" +
                "temp=" + temp +
                ", hum=" + hum +
                ", light=" + light +
                ", wind=" + wind +
                ", pressure=" + pressure +
                ", db=" + db +
                '}';
    }
}
