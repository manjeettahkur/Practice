package Array;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 13/9/16.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int arr[] = new int[n];
        int arr1[] = new int[k];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }


        for (int i = 0; i < k; i++) {
            arr1[i] = arr[n - 1 - i];
        }
        int x = n - 1;
        for (int i = n - k - 1; i > -1; i--) {
            arr[x--] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.print(arr1[i] + " ");
        }
        for (int i = 0; i < k; i++) {
            arr[i] = arr1[k - 1 - i];
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}