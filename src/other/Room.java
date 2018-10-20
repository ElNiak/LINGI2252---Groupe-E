package other;

import device.*;
import sensor.Sensor;

import java.util.ArrayList;
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
                           i.start();
                       }
                   }
               }
               else {
                   for (Device i : devices) {
                       if (i instanceof Heating) {
                           i.start();
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
                            i.start();
                        }
                        if (i instanceof ShutterWindow) {
                            i.start();
                        }
                    }
                }
                else {
                    for (Device i : devices) {
                        if (i instanceof Light) {
                            i.start();
                        }
                        if (i instanceof ShutterWindow) {
                            i.start();
                        }
                    }
                }
                break;
            case Constants.WIND:
                if(wind < environnement.getWind()){
                    for (Device i : devices) {
                        if (i instanceof Windows) { //On
                            i.start();
                        }
                    }
                }
                else {
                    for (Device i : devices) {
                        if (i instanceof Ventillation) { //Off
                            i.start();
                        }
                    }
                }
                break;
            case Constants.POLLUTION:
                if(pollution < environnement.getPollution()){
                    for (Device i : devices) {
                        if (i instanceof Windows) {
                            i.start();
                        }
                    }
                }
                else {
                    for (Device i : devices) {
                        if (i instanceof Windows) {
                            i.start();
                        }
                    }
                }
                break;
            case Constants.DBEL:
                if(dbel < environnement.getDbel()){
                    for (Device i : devices) {
                        if (i instanceof Hifi) {
                            i.start();
                        }
                    }
                }
                else {
                    for (Device i : devices) {
                        if (i instanceof Hifi) {
                            i.start();
                        }
                    }
                }
                break;
            //case Constants.MOVEMENT:
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
}
