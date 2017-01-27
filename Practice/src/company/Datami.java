package company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 8/1/17.
 */
public class Datami {

    public static void main(String [] args){
      /*  Scanner sc = new Scanner(System.in);
        int Row = sc.nextInt();*/

        int arr[] = new int[5];
        for(int i = 6;i>0;i--){
            arr[6-i] = i;
        }
        Arrays.fill(arr,1,4,5);
        for(int i =0;i<6;i++)
            System.out.println(arr[i]);

          }
}
