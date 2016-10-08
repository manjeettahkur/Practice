package Array;

/**
 * Created by laxminarayanvarma on 30/9/16.
 */
public class CalculateMaxOccurance {
    public static void main (String[] args)
    {

        int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
        int n = arr.length;
        int k=8;
        System.out.println("Maximum repeating element is: " +
                maxRepeating(arr,n,k));
    }

    static int maxRepeating(int arr[], int n, int k)
    {   printArray(arr);
        for (int i = 0; i< n; i++)
            arr[(arr[i]%k)] += k;
        printArray(arr);
        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }

        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k;
        printArray(arr);
        return result;
    }
    public static void printArray(int arr[]){
        for (int x : arr)
            System.out.print(x+" ");
        System.out.println();
    }
}
