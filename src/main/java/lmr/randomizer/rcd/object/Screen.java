package lmr.randomizer.rcd.object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thezerothcat on 7/16/2017.
 */
public class Screen implements ObjectContainer {
    private String name;
    private int zoneIndex;
    private int roomIndex;
    private int screenIndex;

    private Zone zone;

    private List<GameObject> objects = new ArrayList<>();
    private List<ScreenExit> screenExits = new ArrayList<>(); //order is top, right, bottom, left

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public int getZoneIndex() {
        return zoneIndex;
    }

    public void setZoneIndex(int zoneIndex) {
        this.zoneIndex = zoneIndex;
    }

    public int getRoomIndex() {
        return roomIndex;
    }

    public void setRoomIndex(int roomIndex) {
        this.roomIndex = roomIndex;
    }

    public int getScreenIndex() {
        return screenIndex;
    }

    public void setScreenIndex(int screenIndex) {
        this.screenIndex = screenIndex;
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public List<ScreenExit> getScreenExits() {
        return screenExits;
    }

    public ScreenExit getScreenExit(int direction) {
        return screenExits.get(direction);
    }

    public List<GameObject> getObjectsById(int id) {
        List<GameObject> objectsById = new ArrayList<>();
        for(GameObject object : objects) {
            if(object.getId() == id) {
                objectsById.add(object);
            }
        }
        return objectsById;
    }

    @Override
    public String toString() {
        StringBuilder returnVal = new StringBuilder(String.format("SCREEN %02d-%02d-%02d \"%s\"", zoneIndex, roomIndex, screenIndex, name));
        if(!objects.isEmpty()) {
            for(GameObject obj : objects) {
                returnVal.append('\n').append(obj.toString());
            }
        }

        ScreenExit exit = screenExits.get(0); // top exit
        returnVal.append(String.format("\n%s %02d-%02d-%02d", "Up", exit.getZoneIndex(), exit.getRoomIndex(), exit.getScreenIndex()));

        exit = screenExits.get(1); // right exit
        returnVal.append(String.format("\n%s %02d-%02d-%02d", "Right", exit.getZoneIndex(), exit.getRoomIndex(), exit.getScreenIndex()));

        exit = screenExits.get(2); // down exit
        returnVal.append(String.format("\n%s %02d-%02d-%02d", "Down", exit.getZoneIndex(), exit.getRoomIndex(), exit.getScreenIndex()));

        exit = screenExits.get(3); // left exit
        returnVal.append(String.format("\n%s %02d-%02d-%02d", "Left", exit.getZoneIndex(), exit.getRoomIndex(), exit.getScreenIndex()));

        return returnVal.toString();
    }

    public String getContainerString() {
        return String.format("SCREEN %02d-%02d-%02d \"%s\"", zoneIndex, roomIndex, screenIndex, name);
    }
}
