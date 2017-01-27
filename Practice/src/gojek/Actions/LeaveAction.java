package gojek.Actions;

import gojek.CarParking;
import gojek.Vehicle;

import java.util.Collections;
import java.util.List;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public class LeaveAction implements Action {
    private Integer slot;

    public LeaveAction(Integer slot){
        this.slot = slot;
    }

    @Override
    public void process(CarParking carParking) {
        Vehicle vehicle = carParking.getSlotMap().remove(this.slot);
        List<Vehicle> al = carParking.getColourMap().get(vehicle.getColour());
        for(int i =0;i<al.size();i++){
            if(al.get(i).getSlot() == this.slot)
                al.remove(i);
        }
        carParking.getrNoMap().remove(vehicle.getrNo());
        carParking.getAvailableSlots().add(this.slot);
        Collections.sort(carParking.getAvailableSlots());
        System.out.println("Slot no "+this.slot+" is free");
    }
}
