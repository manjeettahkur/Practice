package gojek.Actions;

import gojek.CarParking;
import gojek.Vehicle;

import java.util.ArrayList;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public class ParkAction implements Action {

    private String rNo;
    private String colour;

    public ParkAction(String rNo, String colour){
        this.rNo = rNo;
        this.colour = colour;
    }

    @Override
    public void process(CarParking carParking) {
        if(carParking.getAvailableSlots().size() > 0){

            int slotNo = carParking.getAvailableSlots().remove(0);
            Vehicle vehicle = new Vehicle(this.rNo,this.colour,slotNo);
            carParking.getSlotMap().put(slotNo,vehicle);

            carParking.getrNoMap().put(this.rNo, slotNo);

            if(carParking.getColourMap().containsKey(colour)){
                carParking.getColourMap().get(colour).add(vehicle);
            }else{
                carParking.getColourMap().put(colour, new ArrayList<Vehicle>());
                carParking.getColourMap().get(colour).add(vehicle);
            }
            System.out.println("Allocated slot number: "+slotNo);
        }else{
            System.out.println("Sorry, parking lot is full");
        }
    }
}
