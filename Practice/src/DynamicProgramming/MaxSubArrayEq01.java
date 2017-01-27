package DynamicProgramming;

import java.util.HashMap;

/**
 * Created by laxminarayanvarma on 20/11/16.
 */
public class MaxSubArrayEq01 {

    public static void main(String[] args)
    {
        int arr[] = {1, 0, 1, 1, 1, 0, 0};
        int n = arr.length;

        maxLen(arr, n);
    }
    static int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        int sum = 0;
        int max_len = 0;
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++){
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++)
        {
            sum += arr[i];

            if (sum == 0){
                max_len = i + 1;
                ending_index = i;
            }

            if (hM.containsKey(sum+n)){
                if (max_len < i - hM.get(sum + n)){
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            }
            else{
                hM.put(sum + n, i);
            }

        }

        for (int i = 0; i < n; i++){
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);
        return max_len;
    }
}
