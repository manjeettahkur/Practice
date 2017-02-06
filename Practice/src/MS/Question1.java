package MS;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 26/1/17.
 */
public class Question1 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        /*int fmax = 0;
        int fmin = Integer.MAX_VALUE;
        for(int i =0 ;i<first.length();i++){
            if(first.charAt(i) > fmax)
                fmax = first.charAt(i);
            if(first.charAt(i) < fmin)
                fmin = first.charAt(i);
        }

        int Smax = 0;
        int Smin = Integer.MAX_VALUE;
        for(int i =0 ;i<second.length();i++){
            if(second.charAt(i) > Smax)
                Smax = second.charAt(i);
            if(second.charAt(i) < Smin)
                Smin = second.charAt(i);
        }

        if(fmax < Smin){
            System.out.println("true");
        }
        if(fmax > Smax)
            System.out.println(false);*/


        int []arr1 = new int[first.length()];
        int []arr2 = new int[first.length()];

        for(int i =0 ;i<first.length();i++){
            arr1[i] = first.charAt(i);
        }
        for(int i =0 ;i<second.length();i++){
            arr2[i] = second.charAt(i);
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean flag = true;

        for(int i =0 ;i<first.length();i++){
            if(!(arr1[i] > arr2[i])){
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
