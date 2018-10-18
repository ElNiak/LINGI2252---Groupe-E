package other;

public class Environnement {

    private double temp;
    private double hum;
    private double light;
    private double wind;
    private double pollution;
    private double dbel;
    private boolean movement;
    private Room room;

    public Environnement() {
    }

    public Environnement(double temp, double hum, double light, double wind, double pollution, double db, boolean movement, Room room) {
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
        switch(type){
            case Constants.TEMP:
                this.temp = val;
                break;
            case Constants.HUM:
                this.hum = val;
                break;
            case Constants.LIGHT:
                this.light = val;
                break;
            case Constants.WIND:
                this.wind = val;
                break;
            case Constants.POLLUTION:
                this.pollution = val;
                break;
            case Constants.DBEL:
                this.dbel = val;
                break;
            case Constants.MOVEMENT:
                if(val == 1.0){
                    this.movement = true;
                }
                else{
                    this.movement = false;
                }
        }
        room.manage(type);
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

    public boolean isMovement() {
        return movement;
    }

    public void setMovement(boolean movement) {
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
                ", db=" + dbel +
                '}';
    }
}
