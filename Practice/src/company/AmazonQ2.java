package company;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 4/1/17.
 */
public class AmazonQ2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int i = 0 ; i<test;i++){
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int j =0;j<N;j++){
                arr[j] = sc.nextInt();
            }
          maxSubArraySum(arr);

        }
    }

    public static void maxSubArraySum(int a[])
    {
        int max_so_far = a[0];
        int curr_max = a[0];
        int maxSum = 0;
        int max = Integer.MIN_VALUE;

        for(int x :  a){
            if(x > 0){
                maxSum += x;

            }
            if(x>max)
                max = x;
        }

        for (int i = 1; i < a.length; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }

        if(maxSum == 0){
            maxSum = max;
        }
        if(max_so_far == 0)
            max_so_far = max;
        System.out.println(maxSum +" "+ max_so_far);
    }
}
