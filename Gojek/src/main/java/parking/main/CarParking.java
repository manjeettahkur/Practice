package parking.main;

import parking.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public class CarParking {

    private static Object lock = new Object();
    private static CarParking parkingLot = null;

    private List<Integer> availableSlots;
    private TreeMap<Integer, Vehicle> slotMap;
    private HashMap<String, List<Vehicle>> colourMap;
    private HashMap<String, Integer> rNoMap;
    private Integer maxCapacity;

    private CarParking(int maxCapacity) {
        this.availableSlots = new ArrayList<Integer>(maxCapacity);
        this.slotMap = new TreeMap<Integer, Vehicle>();
        this.colourMap = new HashMap<String, List<Vehicle>>();
        this.rNoMap = new HashMap<String, Integer>();
        this.maxCapacity = maxCapacity;
    }

    public static CarParking getInstance(int maxSize) {
        if (parkingLot == null) {
            synchronized (lock) {
                if (parkingLot == null)
                    parkingLot = new CarParking(maxSize);
                populateInitialSlot(maxSize);
                System.out.println("Created a parking lot with " + maxSize + " slots");
            }
        }
        return parkingLot;
    }

    public static void populateInitialSlot(int maxSize) {
        for (int i = 0; i < maxSize; i++) {
            parkingLot.getAvailableSlots().add(i + 1);
        }
    }

    public List<Integer> getAvailableSlots() {
        return availableSlots;
    }

    public TreeMap<Integer, Vehicle> getSlotMap() {
        return slotMap;
    }

    public HashMap<String, List<Vehicle>> getColourMap() {
        return colourMap;
    }

    public HashMap<String, Integer> getrNoMap() {
        return rNoMap;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }
}
