package String;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 12/9/16.
 * https://www.hackerrank.com/challenges/reduced-string
 * Input: aaabccddd
 * Output: abd
 */
public class RemoveDuplicat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        int loops = input.length()/2;
        for(int i =0 ; i<loops;i++){
            for(int j = 0;j<input.length()-1;j++){
                if(input.charAt(j)== input.charAt(j+1)){
                   input = input.replace(input.substring(j,j+2),"");
                    break;
                }
            }
            if(input.length() == 0)
                break;
        }
        if(input.length() == 0){
            System.out.println("Empty String");
        }else{
            System.out.println(input);
        }
    }
}
