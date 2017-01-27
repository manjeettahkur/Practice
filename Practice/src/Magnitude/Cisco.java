package Magnitude;

/**
 * Created by laxminarayanvarma on 25/12/16.
 */
public class Cisco {
    public static void main(String [] args){
        int arr [] = {82921272,110219722,162495938,470311130,583170602,329963077,403414481,437623101,485366585,599466263,959094281};
        System.out.println(getCount(arr));

    }

    public static int getCount(int arr[]){
        int left = 0;
        int right = arr.length -1;
        int result = 0;
        while (left < right)
        {

            while (arr[left]%2 == 0 && left < right)
                left++;

        /* Decrement right index while we see 1 at right */
            while (arr[right]%2 == 1 && left < right)
                right--;

            if (left < right)
            {
            /* Swap arr[left] and arr[right]*/
                swap(arr,left,right);
                result++;
                left++;
                right--;
            }
        }
        return result;
    }

    static void swap (int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
