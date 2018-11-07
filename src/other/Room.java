package other;

import device.*;
import sensor.Sensor;

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
    private boolean movement;
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
    }

    public Environnement getEnvironnement(){
        return this.environnement;
    }

    public void manage(String type){
        switch(type){
            case Constants.TEMP:
               if(temp < environnement.getTemp()) {
                   for (Device i : devices) {
                       if (i instanceof AirConditioning) {
                           i.manage_device();
                       }
                   }
               }
               else {
                   for (Device i : devices) {
                       if (i instanceof Heating) {
                           i.manage_device();
                       }
                   }
               }
                break;
            case Constants.HUM:
                if(hum < environnement.getHum()){

                }
                break;
            case Constants.LIGHT:
                if(light < environnement.getLight()){
                    for (Device i : devices) {
                        if (i instanceof Light) {
                            i.manage_device();
                        }
                        if (i instanceof ShutterWindow) {
                            i.manage_device();
                        }
                    }
                }
                break;
            case Constants.WIND:
                if(wind < environnement.getWind()){
                    for (Device i : devices) {
                        if (i instanceof Windows) { //On
                            i.manage_device();
                        }
                    }
                }
                else {
                    for (Device i : devices) {
                        if (i instanceof Ventillation) { //Off
                            i.manage_device();
                        }
                    }
                }
                break;
            case Constants.POLLUTION:
                if(pollution < environnement.getPollution()){
                    for (Device i : devices) {
                        if (i instanceof Windows) {
                            i.manage_device();
                        }
                    }
                }
                else {
                    for (Device i : devices) {
                        if (i instanceof Windows) {
                            i.manage_device();
                        }
                    }
                }
                break;
            case Constants.DBEL:
                if(dbel < environnement.getDbel()){
                    for (Device i : devices) {
                        if (i instanceof Hifi) {
                            i.manage_device();
                        }
                    }
                }
                else {
                    for (Device i : devices) {
                        if (i instanceof Hifi) {
                            i.manage_device();
                        }
                    }
                }
                break;
            case Constants.MOVEMENT:
                if(movement != environnement.isMovement()){
                    for (Device i : devices){
                        if (i instanceof Light){
                            i.manage_device();
                        }
                        if (i instanceof Tv){
                            i.manage_device();
                        }
                    }
                }
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", devices=" + devices +
                ", sensors=" + sensors +
                ", hauteur=" + hauteur +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                ", neightbor=" + Arrays.toString(neightbor) +
                ", temp=" + temp +
                ", hum=" + hum +
                ", light=" + light +
                ", wind=" + wind +
                ", pollution=" + pollution +
                ", dbel=" + dbel +
                ", movement=" + movement +
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

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }
}
