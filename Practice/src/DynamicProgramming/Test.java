package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 16/12/16.
 */
public class Test {
    public static void main(String args[]) throws IOException {

       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());*/

        //String input = br.readLine();

        //String [] sc = input.split(" ");

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer arr[] = new Integer[N];
        for(int i = 0; i< N ;i++)
            arr[i] = sc.nextInt();

         printBiggestNumber(arr);

    }
    private static void printBiggestNumber(Integer [] arr) {
        Arrays.sort(arr,new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String s1 = a.toString() + b.toString();
                String s2 = b.toString() + a.toString();
                return s2.compareTo(s1);
            }
        });
        String out = "";
        for(Integer s : arr){
            out += s;
        }
        System.out.println(out);
    }
}


