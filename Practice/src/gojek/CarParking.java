package gojek;

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

    private CarParking(int size) {
        this.availableSlots = new ArrayList<>(6);
        this.slotMap = new TreeMap<>();
        this.colourMap = new HashMap<>();
        this.rNoMap = new HashMap<>();
    }

    public static CarParking getInstance(int maxSize) {
        if (parkingLot == null) {
            synchronized (lock) {
                if (parkingLot == null)
                    parkingLot = new CarParking(maxSize);
                populateInitialSlot(maxSize);
                System.out.println("Created a parking lot with " + maxSize + " slots");
            }
        } else {
            System.out.println("Parking lot already created. Returning old created instance.");
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
}
