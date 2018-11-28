package other;

public class Environnement {

    private double temp; // en degré celcius
    private double hum;
    private double light;
    private double wind; // en km/h
    private double pollution;
    private double dbel; // en décibel
    private double movement;
    private Room room;

    public Environnement() {
        this.temp = 18.0;
        this.hum = 10.0;
        this.light = 10.0;
        this.wind = 30.0;
        this.pollution = 10.0;
        this.dbel = 10.0;
        this.movement = 0.0;
    }

    public Environnement(Room room) {
        this.temp = 18.0;
        this.hum = 10.0;
        this.light = 10.0;
        this.wind = 30.0;
        this.pollution = 10.0;
        this.dbel = 10.0;
        this.movement = 0.0;
    }

    public Environnement(double temp, double hum, double light, double wind, double pollution, double db, double movement, Room room) {
        this.temp = temp;
        this.hum = hum;
        this.light = light;
        this.wind = wind;
        this.pollution = pollution;
        this.dbel = db;
        this.movement = movement;
        this.room = room;
    }

    /**
     * @pre /
     * @post /
     */
    public void update(String type, double val) {
        room.manage(type, val);
        switch (type) {
            case Constants.TEMP:
                this.setTemp(val);
                break;
            case Constants.HUM:
                this.setHum(val);
                break;
            case Constants.LIGHT:
                this.setLight(val);
                break;
            case Constants.WIND:
                this.setWind(val);
                break;
            case Constants.POLLUTION:
                this.setPollution(val);
                break;
            case Constants.DBEL:
                this.setDbel(val);
                break;
            case Constants.MOVEMENT:
                if (val == 1.0) {
                    this.setMovement(1.0);
                } else {
                    this.setMovement(0.0);
                }
        }
        //room.manage(type);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        this.hum = hum;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getPollution() {
        return pollution;
    }

    public void setPollution(double pollution) {
        this.pollution = pollution;
    }

    public double getDbel() {
        return dbel;
    }

    public void setDbel(double dbel) {
        this.dbel = dbel;
    }

    public double isMovement() {
        return movement;
    }

    public void setMovement(double movement) {
        this.movement = movement;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Environnement{" +
                "temp=" + temp +
                ", hum=" + hum +
                ", light=" + light +
                ", wind=" + wind +
                ", pollution=" + pollution +
                ", dbel=" + dbel +
                ", movement=" + movement +
                ", room=" + room.getName() +
                '}';
    }
}
