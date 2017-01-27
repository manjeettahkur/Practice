package parking.actions;

import parking.main.CarParking;
import parking.model.Vehicle;

import java.util.Map;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public class StatusAction  implements Action {

    public void process(CarParking carParking) {
        if(carParking.getSlotMap().size() > 0){
            System.out.println("Slot No.     " + "Registration No      " +"Colour");
            for(Map.Entry<Integer, Vehicle> entry : carParking.getSlotMap().entrySet()) {
                Integer slot = entry.getKey();
                Vehicle vehicle = entry.getValue();
                System.out.println(vehicle.getSlot()+"            "+vehicle.getrNo()+"        "+vehicle.getColour());
            }
        }else {
            System.out.println("Parking Lot empty.");
        }
    }
}
