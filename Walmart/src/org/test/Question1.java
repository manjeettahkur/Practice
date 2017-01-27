package org.test;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 28/9/16.
 */
public class Question1 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int kohli[] = new int[count];
        int dhoni[] = new int[count];

        for(int i = 0;i<count;i++){
            kohli[i] = sc.nextInt();
        }
        for(int i = 0;i<count;i++){
            dhoni[i] = sc.nextInt();
        }
        System.out.println(kohliDhoniDiff(kohli,dhoni));
    }

    public static int kohliDhoniDiff(int []kohli,int[] dhoni){
        int diff = 0;
        for(int i = 0;i<kohli.length;i++){
            if(kohli[i] != dhoni[i]){
                int j = i+1;
                while(kohli[i] != dhoni[j]){
                    j++;
                }
                while(j!= i){
                    swap(dhoni,j,j-1);
                    j--;
                    diff++;
                }
            }
        }

        return diff;
    }

    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
}
