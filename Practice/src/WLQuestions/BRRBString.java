package WLQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by laxminarayanvarma on 23/9/16.
 * Given n strings consisting of ‘R’ and ‘B’. Two strings can be only combined if last character of first
 * string and first character of second string are same. Given n strings, you have to output the maximum length
 * possible by combining strings.
 I/P
 RBR
 BBR
 RRR
 output : 9
 */
public class BRRBString {
    public static void main(String []args){
       // String []arr = {"RRRR", "BBB", "R", "BBB", "RBBBB", "RRB", "BRBR", "RBBB", "BR"};
        String []arr = {"RBR", "BBR", "RRR" };
        List<String> arrList = Arrays.asList(arr);
        for(String str : arr) {
            System.out.print(str + " ");
        }
        System.out.println(getLongest(arrList));
    }

    public static int getLongest(List<String> strs) {
        if (strs == null) {
            throw new NullPointerException();
        }
        if (strs.size() == 0) {
            return 0;
        }

        //break the input into major groupings
        int bbLength = 0;
        ArrayList<Integer> br = new ArrayList<Integer>();
        int rrLength = 0;
        ArrayList<Integer> rb = new ArrayList<Integer>();
        for (String str : strs) {
            if (str.charAt(0) == 'B') {
                if (str.charAt(str.length() - 1) == 'B') {
                    bbLength += str.length();
                } else {
                    br.add(str.length());
                }
            } else {
                if (str.charAt(str.length() - 1) == 'B') {
                    rb.add(str.length());
                } else {
                    rrLength += str.length();
                }
            }
        }
        //Sort to support greedy operations
        Collections.sort(br);
        Collections.sort(rb);
        //now do the ping ponging
        //if there are BR strings
        if(br.size() > 0){
            int val = 0;
            //if there are also RB strings
            if(rb.size() > 0){
                //if there are more BR strings, start there
                if(br.size() > rb.size()){
                    val = br.remove(br.size() - 1);
                }
                //if there are more RB strings, start there
                else if(rb.size() > br.size()){
                    val = rb.remove(rb.size() - 1);
                }
                //while there are both BR and RB strings, use them
                while(br.size() > 0 && rb.size() > 0){
                    val += br.remove(br.size() - 1);
                    val += rb.remove(rb.size() - 1);
                }
            }
            //otherwise there is only the BR string, use the max
            else{
                val += br.remove(br.size() - 1);
            }
            //add the BB and RR string lengths
            val += bbLength;
            val += rrLength;
            return val;
        }
        //if there are only RB strings, use the max there
        else if (rb.size() > 0){
            int val = rb.remove(rb.size() - 1);
            val += bbLength;
            val += rrLength;
        }
        //else there are only BB and RR strings. Use the longest one of those
        else{
            return Math.max(bbLength, rrLength);
        }
        return 0;
    }

    }
