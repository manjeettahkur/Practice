package String;

import java.util.HashMap;

/**
 * Created by laxminarayanvarma on 26/10/16.
 */
public class MinWindowContainAllCharacter {
    public static void main(String []args){
        String input = "this is test string";
        String pattern = "tist";
        System.out.println(getMinWindow(input,pattern));

    }


    public static String getMinWindow(String input,String pattern){
        int len = pattern.length();
        int [] mp = new int[256];
        int count = len;
        for(int i = 0; i < len; ++i){
            mp[pattern.charAt(i)]++;
        }
        int l = 0,r = 0, fl=0, fr=0;
        int n = input.length();
        int min_len = 999999;
        while(r<n){
            if(mp[input.charAt(r)] > 0){
                count--;
            }
            mp[input.charAt(r)]--;

            while(count == 0){
                if(min_len > r-l+1){
                    min_len = r-l+1;
                    fl = l;
                    fr = r;
                }
                if(mp[input.charAt(l)] == 0){
                    count++;
                }
                mp[input.charAt(l)]++;
                l++;
            }
            r++;
        }
        if(min_len == 999999){
            return "";
        }
        return input.substring(fl, fr-fl+1);
    }
}
