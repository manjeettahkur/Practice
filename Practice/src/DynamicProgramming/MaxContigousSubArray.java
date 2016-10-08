package DynamicProgramming;

/**
 * Created by laxminarayanvarma on 30/9/16.
 */
public class MaxContigousSubArray {
    public static void main (String[] args)
    {
        int a[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println("Maximum circular sum is " + kadane(a));
             //   maxCircularSum(a));
    }
    static int kadane (int a[])
    {
        int n = a.length;
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < n; i++)
        {
            System.out.print(max_ending_here+"  ");
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        System.out.print(max_ending_here);
        System.out.println();
        return max_so_far;
    }
}
