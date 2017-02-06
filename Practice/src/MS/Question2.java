package MS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by laxminarayanvarma on 26/1/17.
 */
public class Question2 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> s = new LinkedList<>();
        int input = Integer.parseInt(br.readLine());

        while(input > 0){
            input--;
            String str = br.readLine();
            String operation = str.split(" ")[0];

            if(operation.equals("push")){
                int num = Integer.parseInt(str.split(" ")[1]);
                s.add(num);
                System.out.println(num);
            }else if(operation.equals("pop")){
                s.removeLast();
                if(s.size() == 0){
                    System.out.println("EMPTY");
                }else{
                    System.out.println(s.getLast());
                }
            }else{
               int x = Integer.parseInt(str.split(" ")[1]);
               int d = Integer.parseInt(str.split(" ")[2]);

                for(int i =0;i<x;i++){
                    s.set(i,s.get(i) + d);
                }
                System.out.println(s.getLast());
            }
        }

    }
}
