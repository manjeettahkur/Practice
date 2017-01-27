package parking.actions;

import parking.main.CarParking;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public class SlotNoByRNoAction implements Action {

    private String rNo;

    public SlotNoByRNoAction(String rNo){
        this.rNo = rNo;
    }

    public void process(CarParking carParking) {
        if(carParking.getrNoMap().containsKey(this.rNo)){
            System.out.println(carParking.getrNoMap().get(this.rNo));
        }else {
            System.out.println("Not found");
        }
    }
}
