package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by laxminarayanvarma on 24/11/16.
 */
public class MatrixChainMultiplication {
    static int MatrixChainOrder(int arr[], int n)
    {
        int temp[][] = new int[n][n];
        int q;

        for (int[] row: temp)
            Arrays.fill(row, -1);

        for (int i = 1; i < n; i++)
            temp[i-1][i] = 0;

        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++){
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length-1];
    }

    public static void main(String args[])
    {
        int arr[] = new int[] {4, 2, 3, 5, 3};
        int size = arr.length;

        System.out.println("Minimum number of multiplications is "+
                MatrixChainOrder(arr, size));
    }
}
