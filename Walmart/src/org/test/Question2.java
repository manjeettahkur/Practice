package org.test;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 28/9/16.
 */
public class Question2 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int limit = sc.nextInt();
        sc.close();

        StringBuilder inputStr = new StringBuilder(input);
        String maxTillNow = new String(inputStr.toString());

        maxTillNow = generateMaxNo(inputStr,limit,maxTillNow);
        System.out.println(maxTillNow);
      //  getMaxNumber(input,limit);
    }
    public static void generateMaxString(StringBuilder input,int limit){
        int n = input.length();
        int newLimit = limit;
        for(int i = 0;i<n-1 && limit > 0;i++){
            limit = newLimit;
            int index = -1;
            char max = input.charAt(i);
            for(int j = i+1;j<i+limit;j++){
                if(input.charAt(j) > input.charAt(i) && input.charAt(j) > max) {
                    max = input.charAt(j);
                    index = j;
                }
            }
            if(index != -1){
                swap(input,i,index);
                newLimit = limit-index-i;
            }
        }
    }


   /* public static void generate(StringBuilder input ,int limit){
        for(int i =0;i<limit;){
            int index = findMaxDigit(input,limit-i);
        }
    }
    static int  findMaxDigit(StringBuilder input,int)*/

    public static String generateMaxNo(StringBuilder input,int limit,String maxTillNow){
        if(limit == 0)
            return maxTillNow;
        int n = input.toString().length();
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(input.charAt(i) < input.charAt(j)){
                    swap(input,i,j);
                    if(input.toString().compareTo(maxTillNow) > 0){
                        maxTillNow = input.toString();
                    }
                    String sub = generateMaxNo(input,limit -1,maxTillNow);

                    if(sub.compareTo(maxTillNow) > 0)
                        maxTillNow = sub;
                    swap(input,i,j);
                }

            }
        }
        return maxTillNow;
    }

    public static void swap(StringBuilder input,int i ,int j){
        char temp = input.charAt(i);
        input.setCharAt(i,input.charAt(j));
        input.setCharAt(j,temp);
    }

    public static void getMaxNumber(String numberStr, final int digitsToSwap) {
        String max = numberStr;
        for (int i = 0; i < digitsToSwap; i++) {
            final char digitToBeSwapped = numberStr.charAt(i);
            for (int j = i + 1; j < numberStr.length(); j++) {
                final char digitsToBeSwappedWith = numberStr.charAt(j);
                final StringBuilder numberStringBuilder = new StringBuilder(numberStr);
                numberStringBuilder.replace(i, i + 1, digitsToBeSwappedWith + "");
                numberStringBuilder.replace(j, j + 1, digitToBeSwapped + "");
                if (numberStringBuilder.toString().compareTo(max) > 0) {
                    max = numberStringBuilder.toString();
                }
            }
            numberStr = max;
        }
        System.out.println(max);
    }
}
