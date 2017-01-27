package gojek.Actions;

import gojek.CarParking;
import gojek.Vehicle;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public class SlotNoByColourAction implements Action {
    private String colour;

    public SlotNoByColourAction(String colour){
        this.colour = colour;
    }

    @Override
    public void process(CarParking carParking) {
        if (carParking.getColourMap().containsKey(this.colour)){
            for(Vehicle ve : carParking.getColourMap().get(this.colour)){
                System.out.print(ve.getSlot()+",");
            }
        }else {
            System.out.print("Not found");
        }
        System.out.println();
    }
}
