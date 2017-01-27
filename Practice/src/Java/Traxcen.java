package Java;

/**
 * Created by laxminarayanvarma on 19/10/16.
 */
public class Traxcen {
    public static void main(String []args){
        String input = "abcdeedcbfgf";
        System.out.println(bomber(input));
    }
    

    public static String bomber(String input){
        char str[] = input.toCharArray();
        int j =0;
        for(int i =1;i<str.length;i++){
            while( (i<str.length) && (j>=0) && (str[i] == str[j])){
                i++;
                j--;
            }
            if(i==str.length)
                str[++j] = str[i-1];
            else
             str[++j] = str[i];
        }
        return String.valueOf(str).substring(0,j+1);
    }
}
