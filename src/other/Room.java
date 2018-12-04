package other;

import Behavior.*;
import device.*;
import sensor.*;

import java.util.Arrays;
import java.util.List;

public class Room {

    private String name;
    private List<Device> devices;
    private List<Sensor> sensors;
    private double hauteur,longueur,largeur; //cm
    private Room[] neightbor;


    private double temp;//Here perfect mesure according to the preference
    private double hum;
    private double light;
    private double wind;
    private double pollution;
    private double dbel;
    private double movement;
    private double oldtemp;//Here perfect mesure according to the preference
    private double oldhum;
    private double oldlight;
    private double oldwind;
    private double oldpollution;
    private double olddbel;
    private double oldmovement;


    private Environnement environnement;


    public Room(String name, double hauteur, double longueur, double largeur, Environnement environnement, List<Sensor> sensors, List<Device> devices){
        this.name = name;
        this.hauteur = hauteur;
        this.longueur = longueur;
        this.largeur = largeur;
        this.environnement = environnement;
        neightbor = new Room[4];
        this.devices = devices;
        this.sensors = sensors;

        this.temp = environnement.getTemp();
        this.hum = environnement.getHum();
        this.light = environnement.getLight();
        this.wind = environnement.getWind();
        this.pollution = environnement.getPollution();
        this.dbel = environnement.getDbel();
        this.movement = environnement.isMovement();

        this.oldtemp = environnement.getTemp();
        this.oldhum = environnement.getHum();
        this.oldlight = environnement.getLight();
        this.oldwind = environnement.getWind();
        this.oldpollution = environnement.getPollution();
        this.olddbel = environnement.getDbel();
        this.oldmovement = environnement.isMovement();
    }

    public Environnement getEnvironnement(){
        return this.environnement;
    }


    /**
     * Possible case
     * @param type
     */
    public void manage(String type, double val){
        BehaviorStrategy behaviorStrategy = new BehaviorStrategy();
        double oldVal = 0.0;
        switch(type){
            case Constants.TEMP:
                behaviorStrategy.setBehavior(new TemperatureStrategy());
                oldVal = this.oldtemp;
                break;
            case Constants.HUM:
                behaviorStrategy.setBehavior(new HumidityStrategy());
                oldVal = this.oldhum;
                break;
            case Constants.LIGHT:
                behaviorStrategy.setBehavior(new LightStrategy());
                oldVal = this.oldlight;
                break;
            case Constants.WIND:
                behaviorStrategy .setBehavior(new WindStrategy());
                oldVal = this.oldwind;
                break;
            case Constants.POLLUTION:
                behaviorStrategy.setBehavior(new PollutionStrategy());
                oldVal = this.oldpollution;
                break;
            case Constants.DBEL:
                behaviorStrategy.setBehavior(new SoundStrategy());
                oldVal = this.olddbel;
                break;
            case Constants.MOVEMENT:
                behaviorStrategy.setBehavior(new MovementStrategy());
                oldVal = this.oldmovement;
                break;
        }
        behaviorStrategy.manage(val, oldVal, devices);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' + "\n" +
                ", devices=" + devices + "\n" +
                ", sensors=" + sensors + "\n" +
                ", hauteur=" + hauteur + "\n" +
                ", longueur=" + longueur + "\n" +
                ", largeur=" + largeur +
                //", neightbor=" + Arrays.toString(neightbor) + "\n" +
                ", temp=" + temp + "\n" +
                ", hum=" + hum + "\n" +
                ", light=" + light + "\n" +
                ", wind=" + wind + "\n" +
                ", pollution=" + pollution + "\n" +
                ", dbel=" + dbel + "\n" +
                ", movement=" + movement + "\n" +
                ", environnement=" + environnement +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public Room[] getNeightbor() {
        return neightbor;
    }

    public void setNeightbor(Room[] neightbor) {
        this.neightbor = neightbor;
    }

    public double getTemp() {
        return temp;
    }

    public double getOldtemp() {
        return oldtemp;
    }

    public void setOldtemp(double oldtemp) {
        this.oldtemp = oldtemp;
    }

    public double getOldhum() {
        return oldhum;
    }

    public void setOldhum(double oldhum) {
        this.oldhum = oldhum;
    }

    public double getOldlight() {
        return oldlight;
    }

    public void setOldlight(double oldlight) {
        this.oldlight = oldlight;
    }

    public double getOldwind() {
        return oldwind;
    }

    public void setOldwind(double oldwind) {
        this.oldwind = oldwind;
    }

    public double getOldpollution() {
        return oldpollution;
    }

    public void setOldpollution(double oldpollution) {
        this.oldpollution = oldpollution;
    }

    public double getOlddbel() {
        return olddbel;
    }

    public void setOlddbel(double olddbel) {
        this.olddbel = olddbel;
    }

    public double isOldmovement() {
        return oldmovement;
    }

    public void setOldmovement(double oldmovement) {
        this.oldmovement = oldmovement;
    }

    public void setTemp(double temp) {
        this.oldtemp = this.temp;
        this.temp = temp;
        for(Sensor s : sensors){
            if(s instanceof TemperatureSensor){
                if(s.isActivated())
                    s.detect();
            }
        }
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        this.oldhum = this.hum;
        this.hum = hum;
        for(Sensor s : sensors){
            if(s instanceof HumiditySensor){
                if(s.isActivated())
                    s.detect();
            }
        }
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.oldlight = this.light;
        this.light = light;
        for(Sensor s : sensors){
            if(s instanceof LightSensor){
                if(s.isActivated())
                    s.detect();
            }
        }
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.oldwind = this.wind;
        this.wind = wind;
        for(Sensor s : sensors){
            if(s instanceof WindSensor){
                if(s.isActivated())
                    s.detect();
            }
        }
    }

    public double getPollution() {
        return pollution;
    }

    public void setPollution(double pollution) {
        this.oldpollution = this.pollution;
        this.pollution = pollution;
        for(Sensor s : sensors){
            if(s instanceof PollutionSensor){
                if(s.isActivated())
                    s.detect();
            }
        }
    }

    public double getDbel() {
        return dbel;
    }

    public void setDbel(double dbel) {
        this.olddbel = this.dbel;
        this.dbel = dbel;
        for(Sensor s : sensors){
            if(s instanceof SoundSensor){
                if(s.isActivated())
                    s.detect();
            }
        }
    }

    public double isMovement() {
        return movement;
    }

    public void setMovement(double movement) {
        this.oldmovement = this.movement;
        this.movement = movement;
        for(Sensor s : sensors){
            if(s instanceof MovementSensor){
                if(s.isActivated())
                    s.detect();
            }
        }
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }

    public void activationD(double i){
        if(!this.devices.get((int)i).isActivated())
            this.devices.get((int)i).setActivated(true);
        System.out.println(this.devices.get((int)i).getName()+ " in room " + this.getName()  + " is activated");
    }

    public void activationS(double i){
        if(!this.sensors.get((int)i).isActivated())
            this.sensors.get((int)i).setActivated(true);
        System.out.println(this.sensors.get((int)i).getClass()+ " in room " + this.getName()  + " is activated");
    }

    public void desactivationD(double i){
        if(this.devices.get((int)i).isActivated())
            this.devices.get((int)i).setActivated(false);
        System.out.println(this.devices.get((int)i).getName()+ " in room " + this.getName()  + " is desactivated");
    }

    public void desactivationS(double i){
        if(this.sensors.get((int)i).isActivated())
            this.sensors.get((int)i).setActivated(false);
        System.out.println(this.sensors.get((int)i).getClass()+ " in room " + this.getName()  + " is desactivated");
    }


}
