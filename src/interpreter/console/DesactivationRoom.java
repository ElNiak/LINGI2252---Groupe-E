package interpreter.console;

import device.Device;
import other.Environnement;
import other.House;
import other.Room;
import sensor.Sensor;

import java.util.LinkedList;
import java.util.List;

public class DesactivationRoom implements Expression_console{
    private String str;
    int i;
    double add;
    int stage;
    List<Room> rooms;
    House house;
    public DesactivationRoom(String str, House house){
        this.str = str;
        this.house =house;
        try {
            add = Double.parseDouble(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
            stage = Integer.parseInt(str.substring(str.indexOf(":") + 1, str.length()));
            i = Integer.parseInt(str.substring(str.indexOf(")") + 2, str.indexOf(":")));
        }
        catch (Exception e){
            add = 0;
            i = 0;
            stage = 0;
        }
        if(stage == 1)
            rooms = house.getGround_floor();
        else
            rooms = house.getFirst_floor();
    }

    @Override
    public void interpret() {
        modifyRoom(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
        System.out.println(str.substring(str.indexOf("(") + 1, str.indexOf(")")) + " is desactivated");


    }
    //{Entry || LivingRoom || Kitchen || DinningRoom || BedRoom || BathRoom || GameRoom || LaundryRoom || Garden}
    public void modifyRoom(String str){
        switch (str){
            case "entry" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("Entry")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("Entry")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "livingroom" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("LivingRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("LivingRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "kitchen" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("Kitchen")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("Kitchen")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "dinningroom" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("DinningRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("DinningRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "bedroom" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("BedRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("BedRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "bathroom" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("BathRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("BathRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "gameroom" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("GameRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("GameRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "laundryroom" :
                for (Room room: house.getGround_floor()) {
                    if(room.getName().equals("LaundryRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
                for (Room room: house.getFirst_floor()) {
                    if(room.getName().equals("LaundryRoom")){
                        room.setActivated(false);
                        return;
                    }
                }
            case "garden" :
                if(house.getGarden() != null)
                    house.getGarden().setActivated(false);

            default:
        }
    }
}
