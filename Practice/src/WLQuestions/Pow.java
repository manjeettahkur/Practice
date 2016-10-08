package WLQuestions;

/**
 * Created by laxminarayanvarma on 23/9/16.
 */
public class Pow {
    public static void main(String []args){
        System.out.println("Power Recusrive : " +powerRecursive(2,10));
        System.out.println("Power Iterative : " +powIterative(2,11));

    }

    public static int powerRecursive(int num,int pow) {
        if (pow < 1)
            return 1;
        else
            return num * powerRecursive(num, pow-1) ;
    }
    public static int powIterative(int base , int exp) {
        if (exp <= 1) return base;
        int total = 1;
        for (int i = 0; i < exp; i++) {
            total = (base * total);
        }
        return total;
    }
}
