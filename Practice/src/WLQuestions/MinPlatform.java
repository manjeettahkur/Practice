package WLQuestions;

import java.util.Arrays;

/**
 * Created by laxminarayanvarma on 26/9/16.
 * http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class MinPlatform {
    public static void main(String[] args){
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr,dep,arr.length));
    }
    static int findPlatform(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n)
        {
            if (arr[i] < dep[j])
            {
                plat_needed++;
                i++;
                if (plat_needed > result)
                    result = plat_needed;
            }
            else
            {
                plat_needed--;
                j++;
            }
        }
        return result;
    }
}
