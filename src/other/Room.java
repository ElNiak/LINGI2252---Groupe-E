package other;

import behavior.*;
import device.*;
import org.reflections.Reflections;
import sensor.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

public class Room {

    private String name;
    private boolean activated;
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

        this.activated = true;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public double getMovement() {
        return movement;
    }

    public double getOldmovement() {
        return oldmovement;
    }

    public Environnement getEnvironnement(){
        if(activated){
            return this.environnement;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
            return null;
        }
    }

    public Sensor create_sensor(String sensor_name, double x, double y, double z, Room room, boolean activated) {
        Reflections reflections = new Reflections("sensor");
        Set<Class<? extends Sensor>> classes = reflections.getSubTypesOf(Sensor.class);
        for (Class<? extends Sensor> cl : classes) {
            if (cl.getName().contains(sensor_name)) {
                try {
                    Sensor sensor = (Sensor) getConstructor(cl).newInstance();
                    sensor.setActivated(activated);
                    sensor.setX(x);
                    sensor.setY(y);
                    sensor.setZ(z);
                    sensor.setRoom(room);
                    return sensor;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public Device create_device(String device_name, double x, double y, double z, Room room, boolean activated){
        Reflections reflections = new Reflections("device");
        Set<Class<? extends Device>> classes = reflections.getSubTypesOf(Device.class);
        for (Class<? extends Device> cl : classes) {
            if (cl.getName().contains(device_name)) {
                try {
                    Device device = (Device) getConstructor(cl).newInstance();
                    device.setX(x);
                    device.setY(y);
                    device.setZ(z);
                    device.setActivated(activated);
                    device.setRoom(room);
                    device.setName(device_name);
                    return device;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private Constructor<?> getConstructor(Class cl){
        Constructor<?> constructor = null;
        for(int i = 0; i<cl.getDeclaredConstructors().length; i++){
            if (cl.getDeclaredConstructors()[i].getParameterCount() == 0){
                constructor = cl.getDeclaredConstructors()[i];
            }
        }
        return constructor;
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
        if(activated){
            this.oldtemp = oldtemp;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getOldhum() {
        return oldhum;
    }

    public void setOldhum(double oldhum) {
        if(activated){
            this.oldhum = oldhum;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getOldlight() {
        return oldlight;
    }

    public void setOldlight(double oldlight) {
        if(activated){
            this.oldlight = oldlight;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getOldwind() {
        return oldwind;
    }

    public void setOldwind(double oldwind) {
        if(activated){
            this.oldwind = oldwind;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getOldpollution() {
        return oldpollution;
    }

    public void setOldpollution(double oldpollution) {
        if(activated){
            this.oldpollution = oldpollution;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getOlddbel() {
        return olddbel;
    }

    public void setOlddbel(double olddbel) {
        if(activated){
            this.olddbel = olddbel;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double isOldmovement() {
        return oldmovement;
    }

    public void setOldmovement(double oldmovement) {
        if(activated){
            this.oldmovement = oldmovement;
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public void setTemp(double temp) {
        if(activated){
            this.oldtemp = this.temp;
            this.temp = temp;
            for(Sensor s : sensors){
                if(s instanceof TemperatureSensor){
                    if(s.isActivated())
                        s.detect();
                }
            }
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getHum() {
        return hum;
    }

    public void setHum(double hum) {
        if(activated){
            this.oldhum = this.hum;
            this.hum = hum;
            for(Sensor s : sensors){
                if(s instanceof HumiditySensor){
                    if(s.isActivated())
                        s.detect();
                }
            }
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        if(activated){
            this.oldlight = this.light;
            this.light = light;
            for(Sensor s : sensors){
                if(s instanceof LightSensor){
                    if(s.isActivated())
                        s.detect();
                }
            }
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        if(activated){
            this.oldwind = this.wind;
            this.wind = wind;
            for(Sensor s : sensors){
                if(s instanceof WindSensor){
                    if(s.isActivated())
                        s.detect();
                }
            }
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getPollution() {
        return pollution;
    }

    public void setPollution(double pollution) {
        if(activated){
            this.oldpollution = this.pollution;
            this.pollution = pollution;
            for(Sensor s : sensors){
                if(s instanceof PollutionSensor){
                    if(s.isActivated())
                        s.detect();
                }
            }
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double getDbel() {
        return dbel;
    }

    public void setDbel(double dbel) {
        if(activated){
            this.olddbel = this.dbel;
            this.dbel = dbel;
            for(Sensor s : sensors){
                if(s instanceof SoundSensor){
                    if(s.isActivated())
                        s.detect();
                }
            }
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public double isMovement() {
        return movement;
    }

    public void setMovement(double movement) {
        if(activated){
            this.oldmovement = this.movement;
            this.movement = movement;
            for(Sensor s : sensors){
                if(s instanceof MovementSensor){
                    if(s.isActivated())
                        s.detect();
                }
            }
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }

    public void activationD(String i){
        if(activated){
            switch (i){
                case "airconditioning":
                    for (Device s : this.devices) {
                        if( s instanceof  AirConditioning){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "heating":
                    for (Device s : this.devices) {
                        if( s instanceof  Heating){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "hifi":
                    for (Device s : this.devices) {
                        if( s instanceof  Hifi){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "humidifier":
                    for (Device s : this.devices) {
                        if( s instanceof  Humidifier){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "light":
                    for (Device s : this.devices) {
                        if( s instanceof  Light){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "shutterwindow":
                    for (Device s : this.devices) {
                        if( s instanceof  ShutterWindow){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "tv":
                    for (Device s : this.devices) {
                        if( s instanceof  Tv){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "ventilation":
                    for (Device s : this.devices) {
                        if( s instanceof  Ventilation){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "windows":
                    for (Device s : this.devices) {
                        if( s instanceof  Windows){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                default:
            }
            System.out.println(i + " in room " + this.getName()  + " are activated");
        }
        else {
            System.out.println("The room (" + this.name + ") is activated");
        }
    }

    public void activationS(String i){
        if(activated){
            switch (i){
                case "camera":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  Camera){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "light":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  LightSensor){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "pollution":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  PollutionSensor){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "movement":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  MovementSensor){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "temperature":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  TemperatureSensor){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "humidity":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  HumiditySensor){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "sonore":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  SoundSensor){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                case "wind":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  WindSensor){
                            if(!s.isActivated())
                                s.setActivated(true);
                        }
                    }
                default:
            }
            System.out.println(i + " in room " + this.getName()  + " are activated");
        }
        else {
            System.out.println("The room (" + this.name + ") is activated");
        }
    }

    public void desactivationD(String i){
        if(activated){
            switch (i){
                case "airconditioning":
                    for (Device s : this.devices) {
                        if( s instanceof  AirConditioning){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "heating":
                    for (Device s : this.devices) {
                        if( s instanceof  Heating){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "hifi":
                    for (Device s : this.devices) {
                        if( s instanceof  Hifi){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "humidifier":
                    for (Device s : this.devices) {
                        if( s instanceof  Humidifier){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "light":
                    for (Device s : this.devices) {
                        if( s instanceof  Light){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "shutterwindow":
                    for (Device s : this.devices) {
                        if( s instanceof  ShutterWindow){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "tv":
                    for (Device s : this.devices) {
                        if( s instanceof  Tv){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "ventilation":
                    for (Device s : this.devices) {
                        if( s instanceof  Ventilation){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "windows":
                    for (Device s : this.devices) {
                        if( s instanceof  Windows){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                default:
            }
            System.out.println(i + " in room " + this.getName()  + " are desactivated");
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }

    public void desactivationS(String i){
        if(activated){
            switch (i){
                case "camera":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  Camera){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "light":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  LightSensor){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "pollution":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  PollutionSensor){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "movement":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  MovementSensor){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "temperature":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  TemperatureSensor){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "humidity":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  HumiditySensor){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                case "sonore":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  SoundSensor){
                            if(s.isActivated())
                                s.setActivated(false);

                        }
                    }
                case "wind":
                    for (Sensor s : this.sensors) {
                        if( s instanceof  WindSensor){
                            if(s.isActivated())
                                s.setActivated(false);
                        }
                    }
                default:
            }
            System.out.println(i + " in room " + this.getName()  + " are desactivated");
        }
        else {
            System.out.println("The room (" + this.name + ") is desactivated");
        }
    }


}
