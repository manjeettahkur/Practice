package WLQuestions;

import java.math.BigInteger;

/**
 * Created by laxminarayanvarma on 26/9/16.
 * http://www.geeksforgeeks.org/walmart-lab-interview-experience-set-7-off-campus/
 */
public class Binomial {
    public static void main(String [] args){
        System.out.println(getTotalCountOfCombinationABCD(20,3));
    }

    public static int getTotalCountOfCombinationABCD(int N,int K){
        BigInteger ret = BigInteger.ONE;
        for (int i = 0; i < K; i++) {
            ret = ret.multiply(BigInteger.valueOf(N+K-i))
                    .divide(BigInteger.valueOf(i+1));
        }
        return ret.intValue();
    }
}
