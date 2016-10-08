package WLQuestions;

import java.util.Arrays;

/**
 * Created by laxminarayanvarma on 26/9/16.
 */
public class GetMaxCountPrime {

    private static int MAX = 1000000;
    private static boolean[] isPrime = generatePrime();
    public static void main (String[] args){

        int index = getMaxOccuredDigit(21,40);
        if (index != 0){
            System.out.println(index);
        }else{
            System.out.println(-1);
        }
    }

    private static int getMaxOccuredDigit(int lower, int higher){
        int[] highestDigitCount = new int[10];
        int max = 0;
        int maxIndex = 0;
        if (lower < 3){
            highestDigitCount[2] = 1;
            lower = 3;
        }
        for (int i = lower; i <= higher; i++){
            int index = (i - 3) >> 1;
            if (((i & 1) != 0)   && isPrime[index]){
                int[] digitsCount = getDigitCount(i);
                for (int j = 0; j < 10; j++){
                    highestDigitCount[j] = highestDigitCount[j] + digitsCount[j];
                    if (highestDigitCount[j] > max){
                        max = highestDigitCount[j];
                    }
                }
            }
        }
        if (max == 0){
            return 0;
        }
        for(int i = 0; i < 10; i++){
            if (highestDigitCount[i] == max){
                maxIndex =  i;
            }
        }
        return maxIndex;
    }

    private static int[] getDigitCount(int prime){
        int[] digitsCount = new int[10];
        Arrays.fill(digitsCount, 0);
        while(prime != 0){
            int lastDigit = prime % 10;
            digitsCount[lastDigit] += 1;
            prime /= 10;
        }

        return digitsCount;
    }

    private static boolean[] generatePrime(){
        int root = (int) Math.sqrt(MAX) + 1;
        root = (root >> 1) - 1;
        int limit = (int) ((MAX - 1) >> 1);
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        for( int i = 0; i< root; i++){
            if(isPrime[i]){
                for(int j = ((i * (i + 3) << 1) + 3), p = (i << 1) + 3; j < limit; j += p){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
