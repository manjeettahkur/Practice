package DynamicProgramming;

/**
 * Created by laxminarayanvarma on 3/10/16.
 */
public class UglyNumber {
    public static void main(String [] args){
        int num = getNthUglyNo(20);
        System.out.println(num);
    }

    public static int getNthUglyNo(int num){
        int ugly[] = new int[num];
        int i2 = 0, i3 = 0, i5 = 0;
        int i;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;
        ugly[0] = 1;

        for(i=1; i<num; i++)
        {
            next_ugly_no = min(next_multiple_of_2,
                    next_multiple_of_3,
                    next_multiple_of_5);
            ugly[i] = next_ugly_no;
            if(next_ugly_no == next_multiple_of_2)
            {
                i2 = i2+1;
                next_multiple_of_2 = ugly[i2]*2;
            }
            if(next_ugly_no == next_multiple_of_3)
            {
                i3 = i3+1;
                next_multiple_of_3 = ugly[i3]*3;
            }
            if(next_ugly_no == next_multiple_of_5)
            {
                i5 = i5+1;
                next_multiple_of_5 = ugly[i5]*5;
            }
        } /*End of for loop (i=1; i<n; i++) */
        printArray(ugly);
        return next_ugly_no;

    }
    public static int min(int a,int b,int c){
        if(a <= b)
        {
            if(a <= c)
                return a;
            else
                return c;
        }
        if(b <= c)
            return b;
        else
            return c;
    }
    public static void printArray(int arr[]){
        for (int x : arr)
            System.out.print(x+" ");
        System.out.println();
    }
}
