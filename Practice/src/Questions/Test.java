package Questions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by laxminarayanvarma on 9/9/16.
 */


public class Test
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       
    }
}
/*

    String pattern = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
    Pattern r = Pattern.compile(pattern, Pattern.MULTILINE+Pattern.CASE_INSENSITIVE);

    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
while(testCases>0){
        String input = in.nextLine();
        Matcher m = r.matcher(input);
        boolean findMatch = true;
        while(m.find( )){
        input = input.replaceAll(m.group(), m.group(1));
        findMatch = false;
        }
        System.out.println(input);
        testCases--;
        }*/
