package DynamicProgramming;

/**
 * Created by laxminarayanvarma on 8/10/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 */
public class RoadCutting {
    public static void main(String [] args){
        int[] price = {3,5,8,9,10,20,22,25};

       // System.out.println(recursiveMaxValue(price,8));
       // System.out.println(maxValue(price));
        System.out.println(maxValue1(price));

    }
    public static int maxValue(int price[]){
        int max[] = new int[price.length+1];
        for(int i=1; i <= price.length; i++){
            for(int j=i; j <= price.length; j++){
                max[j] = Math.max(max[j], max[j-i] + price[i-1]);
            }
        }
        return max[price.length];
    }

    public static int maxValue1(int price[]){
        int max[] = new int[price.length+1];
        for(int i=1; i <= price.length; i++){
            max[i] = price[i-1];
        }
        printArray(max);
        for(int i=1 ; i <= price.length; i++){
            for(int j=1; j < i ; j++){
                max[i] = Math.max(max[i], max[i-j] + max[j]);
            }
            printArray(max);
        }
        return max[price.length];
    }
    public static int recursiveMaxValue(int price[],int len){
        if(len <= 0){
            return 0;
        }
        int maxValue = 0;
        for(int i=0; i < len;i++){
            int val = price[i] + recursiveMaxValue(price, len-i-1);
            if(maxValue < val){
                maxValue = val;
            }
        }
        return maxValue;
    }
    public static void printArray(int arr[])
    {
        for(int x : arr)
            System.out.print(x+" ");
        System.out.println();
    }
}
