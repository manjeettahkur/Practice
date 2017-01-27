package Heap;

import Tree.Node;

/**
 * Created by laxminarayanvarma on 27/12/16.
 */
public class HeapCheck {
    public static void main(String [] args){
        int arr[] = {40,34,23,31,20,17,24};
        System.out.println(arrayHeapCheck(arr));
    }
    public static boolean arrayHeapCheck(int arr[]){
        boolean flag = true;
        int n = arr.length;

        for(int i =0;i<= n/2 -1;i++){
            if(arr[2*i +1] > arr[i] || 2*i+2 <= n-1 && arr[2*i+2] > arr[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean isBinaryTreeHeapOrNot(Node root){
        return false;
    }
}
