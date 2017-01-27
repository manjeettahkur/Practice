package Java;

/**
 * Created by laxminarayanvarma on 22/12/16.
 */
public class Override {
    public int sum (int x, float y){
        return (int) (x +y);
    }
    public int sum (float x , int y){
        return (int) (x + y);
    }

    public static void main(String [] args){
        Override obj = new Override();

    }
}
