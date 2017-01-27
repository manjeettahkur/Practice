import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parking.actions.Action;
import parking.actions.LeaveAction;
import parking.actions.ParkAction;
import parking.actions.StatusAction;
import parking.main.ApplicationMain;
import parking.main.CarParking;

/**
 * Created by laxminarayanvarma on 11/11/16.
 */
public class parking {

    CarParking carParking;
    ApplicationMain main;
    @Before
    public void setup(){
       carParking = CarParking.getInstance(6);
       main = new ApplicationMain();
    }

    @Test
    public void validation(){
        Assert.assertNotNull(carParking);
        Assert.assertNotNull(carParking.getAvailableSlots());
        Assert.assertNotNull(carParking.getColourMap());
        Assert.assertNotNull(carParking.getrNoMap());
        Assert.assertNotNull(carParking.getSlotMap());
    }

    @Test
    public void checkSingelton(){
        CarParking carParking1 = CarParking.getInstance(4);
        CarParking carParking2 = CarParking.getInstance(5);
        Assert.assertEquals(carParking1,carParking2);
        Assert.assertEquals(carParking1.getAvailableSlots().size(), carParking2.getAvailableSlots().size());
    }

    @Test
    public void checkParkActions(){
        String input = "park KA-01-HH-7777 Red";
        Action action = main.getAction(input);
        Assert.assertEquals(true, action instanceof ParkAction);
    }

    @Test
    public void checkLeaveActions(){
        String input = "leave 4";
        Action action = main.getAction(input);
        Assert.assertEquals(true, action instanceof LeaveAction);
    }

    @Test
    public void checkStatusActions(){
        String input = "status";
        Action action = main.getAction(input);
        Assert.assertEquals(true, action instanceof StatusAction);
    }

    @Test
    public void checkSlotValue(){
        int expectedSlot = carParking.getAvailableSlots().get(0);
        String input = "park KA-01-HH-2701 Blue";
        main.getAction(input).process(carParking);
        int allocatedSlot = carParking.getrNoMap().get("KA-01-HH-2701");
        Assert.assertEquals(expectedSlot,allocatedSlot);
    }

    @Test
    public void checkParkingFull(){
        String input;
        for (int i =0; i< 6; i++){
            input = "park KA-01-HH-270" + i+1+" Blue";
            main.getAction(input).process(carParking);
        }
        input = "park KA-01-HH-2707 Blue";
        main.getAction(input).process(carParking);
        Assert.assertEquals(false, carParking.getrNoMap().containsKey("KA-01-HH-2707"));

    }


    @Test
    public void validateLeaveAction(){
        String input;
        for (int i =0; i< 6; i++){
            input = "park KA-01-HH-270" + i+1+" Blue";
            main.getAction(input).process(carParking);
        }
        input = "leave 2";
        main.getAction(input).process(carParking);
        Assert.assertEquals(false,carParking.getSlotMap().containsKey(2));
        int slot = carParking.getAvailableSlots().get(0);
        Assert.assertEquals(2, slot);
    }

    @Test
    public void getParkingStatus(){
        String input;
        for (int i =0; i< 4; i++){
            input = "park KA-01-HH-270" + i+1+" Blue";
            main.getAction(input).process(carParking);
        }
        int allocatedSlot = carParking.getSlotMap().size();
        int expectedAllocatedSlot = carParking.getMaxCapacity() - carParking.getAvailableSlots().size();
        Assert.assertEquals(allocatedSlot,expectedAllocatedSlot);
    }
}
