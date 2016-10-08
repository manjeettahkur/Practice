package WLQuestions;

/**
 * Created by laxminarayanvarma on 22/9/16.
 */
public class SqRootPrecision {
    public static void main(String []args){

        System.out.println(sqRoot(24));

    }
    public static double sqRoot(double x)
    {
        double fa = x / 2;
        double sa = x / fa;
        double ta = (fa + sa) / 2.0;
        while (Math.abs(x - Math.pow(ta, 2)) > 0.000000001)
        {
            fa = ta;
            sa = x / fa;
            ta = (fa + sa) / 2;
        }
        return ta;
    }

}
