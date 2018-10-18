package other;

import device.*;
import sensor.Sensor;

import java.util.ArrayList;
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
    private Environnement environnement;

    public Room(String name,double hauteur, double longueur, double largeur, double temp, double hum, double db, double wind, double light, double pollution) {
        this.name = name;
        this.temp = temp;
        this.hum = hum;
        this.light = light;
        this.wind = wind;
        this.pollution = pollution;
        this.dbel = db;
        this.devices = new ArrayList<>();
        this.sensors = new ArrayList<>();
        this.hauteur = hauteur;
        this.longueur = longueur;
        this.largeur = largeur;
        neightbor = new Room[4];
        environnement = new Environnement();
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
}
