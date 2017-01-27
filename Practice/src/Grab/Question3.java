package Grab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by laxminarayanvarma on 19/11/16.
 */
public class Question3 {
    public static void main(String args[]){
       int arr[] = {9,1,4,9,0,4,8,9,0,1};
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int capital = -1;
        for(int x = 0; x<arr.length;x++){
            if(arr[x] == x)
                capital = arr[x];
            if(map.containsKey(arr[x])){
                if (arr[x] != x)
                     map.get(arr[x]).add(x);
            }
            else{
                map.put(arr[x], new ArrayList<Integer>());
                if (arr[x] != x)
                    map.get(arr[x]).add(x);
            }
        }
        ArrayList<Integer> temp1 = new ArrayList<Integer>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        int result[] = new int[arr.length -1];
        Arrays.fill(result,0);
        int totalPath = 0;
        temp1.addAll(map.get(capital));
        for(int x = 0; x<arr.length -1;x++){
            int count = 0;
            if(x % 2 == 0){
                count = temp1.size();
                temp2.clear();
                for (int val : temp1){
                    if (map.containsKey(val))
                        temp2.addAll(map.get(val));
                }
            }else{
                count = temp2.size();
                temp1.clear();
                for (int val : temp2){
                    if (map.containsKey(val))
                        temp1.addAll(map.get(val));
                }
            }
            result[x] = count;
            totalPath += count;
            if (totalPath == arr.length -1)
                break;
        }
    }
}
