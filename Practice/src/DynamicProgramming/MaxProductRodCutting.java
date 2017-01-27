package DynamicProgramming;

/**
 * Created by laxminarayanvarma on 8/10/16.
 */
public class MaxProductRodCutting {
    public static void main(String [] args){

     //   System.out.println(maxProduct(4));
        System.out.println(maxProd(8));
    }
    public static void printArray(int arr[])
    {
        for(int x : arr)
            System.out.print(x+" ");
        System.out.println();
    }
    public static int maxProduct(int num){//Max product when zero or more cuts allowed
        int T[] = new int[num+1];
        T[0] = 1;
        for(int i=1; i <= num; i++){
            T[i] = i;
        }
        printArray(T);
        for(int i=2; i <= num; i++){
            for(int j=1; j <= i; j++){
                T[i] = Math.max(T[i],T[j]*T[i-j]);
            }
            printArray(T);
        }
        return T[num];
    }
    static int maxProd(int n)//Max product when atleast one cut is must
    {
        int val[] = new int[n+1];;
        val[0] = val[1] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i <= n; i++)
        {
            int max_val = 0;
            for (int j = 1; j <= i/2; j++)
                max_val = Math.max(max_val, Math.max((i-j)*j, j*val[i-j]));
            val[i] = max_val;
            printArray(val);
        }
        return val[n];
    }
}
