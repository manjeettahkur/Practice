package Heap;

/**
 * Created by laxminarayanvarma on 29/12/16.
 */
public class HeapSort {
    public static void main(String [] args){
        int arr[] = {2,3,4,1,4,2,5,6,7};
        sort(arr);
        for(int x :arr)
            System.out.println(x);
    }

    public static void sort(int arr[]){
        int n = arr.length;
        heapify(arr,n/2-1,n-1);

        for(int i =0;i<n-1; i++){
            swap(arr,n-1-i,0);
            heapify(arr,(n-1-i)/2 -1,n-2-i);
        }
    }

    public static void heapify(int arr[],int i,int n){
        if(i<0)
            return;
        int left = 2*i +1;
        int right = 2*i +2;


        if(left <= n && arr[i] < arr[left] ){
            swap(arr,i,left);
        }
        if(right <= n && arr[i] < arr[right] ){
            swap(arr,i,right);
        }
        if(i != 0 ){
            heapify(arr,i-1, n);
        }

    }

    public static void swap(int arr[],int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
