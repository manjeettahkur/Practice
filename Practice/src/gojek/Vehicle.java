package gojek;

/**
 * Created by laxminarayanvarma on 10/11/16.
 */
public class Vehicle {

    private String rNo;
    private String colour;
    private Integer slot;

    public Vehicle(String rNo, String colour, Integer slot) {
        this.rNo = rNo;
        this.colour = colour;
        this.slot = slot;
    }

    public String getrNo() {
        return rNo;
    }

    public String getColour() {
        return colour;
    }

    public Integer getSlot() {
        return slot;
    }
}
