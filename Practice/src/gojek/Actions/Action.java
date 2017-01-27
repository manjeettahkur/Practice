package gojek.Actions;

import gojek.CarParking;

/**
 * Created by laxminarayanvarma on 9/11/16.
 */
public interface Action {
    public void process(CarParking carParking);
}
