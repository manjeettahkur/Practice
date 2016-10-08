package Array;

/**
 * Created by laxminarayanvarma on 27/9/16.
 */
public class FindMaximum {
    /* Utility Functions to get max and minimum of two integers */
    int max(int x, int y)
    {
        return x > y ? x : y;
    }

    int min(int x, int y)
    {
        return x < y ? x : y;
    }

    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);

        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);
        printArray(LMin);
        printArray(RMax);

        i = 0; j = 0; maxDiff = -1;
        while (j < n && i < n)
        {
            if (LMin[i] < RMax[j])
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }

    /* Driver program to test the above functions */
    public static void main(String[] args)
    {
        FindMaximum max = new FindMaximum();
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        printArray(arr);
        int n = arr.length;
        int maxDiff = max.maxIndexDiff(arr, n);
        System.out.println(maxDiff);
    }
    public static void printArray(int []arr)
    {
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}
