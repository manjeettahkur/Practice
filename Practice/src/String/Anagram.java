package String;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 13/9/16.
 * Print all permutations or anagram of a String
 * Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.
 */
public class Anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        in.close();
        StringBuilder str = new StringBuilder(input);
        anagram(str,0,str.length());
    }
    public static void anagram(StringBuilder input,int start,int end){
        if(start == end)
            System.out.println(input);
        else{
            for(int i = start;i<end;i++){
                swap(input,start,i);
                anagram(input,start+1,end);
                swap(input,start,i);
            }
        }
    }
    public static void swap(StringBuilder input,int i,int j){
        char z = input.charAt(i);
        input.setCharAt(i,input.charAt(j));
        input.setCharAt(j,z);
    }
}
