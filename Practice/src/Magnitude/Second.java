package Magnitude;

import java.util.HashMap;

/**
 * Created by laxminarayanvarma on 25/12/16.
 */
public class Second {
    public static void main(String [] args){
        int arr [] = {5,1,3,4,6,2};
        System.out.println();
        getSmall(arr);
        HashMap<Character,Integer> ma = new HashMap<>();

    }

    static void getSmall(int arr[]){
        int temp [] = new int [arr.length];
        temp[arr.length -1] = 0;
        int min = arr[arr.length - 1];
        for(int i = arr.length -2; i > -1; i--){
            if(min < arr[i] ){
                if (arr[i] >= arr[i+1]){
                    temp[i] = arr[i+1];
                }
                else{
                    temp[i] = min;
                }

            }
            else{
                temp[i] = 0;
            }

            if(min > arr[i])
                min = arr[i];
        }
        int sum = 0;
        for(int x : temp ){
            System.out.print(x);
            sum += x;
        }
      //  System.out.println(arr);
        System.out.println();
        System.out.println(sum);
    }
}
