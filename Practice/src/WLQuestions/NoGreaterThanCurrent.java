package WLQuestions;

/**
 * Created by laxminarayanvarma on 23/9/16.
 * http://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
 * Smaller or greater.
 */
public class NoGreaterThanCurrent {
    public static void main(String []args){
        int arr[] = {5, 3, 9, 8, 2, 6};
       // methodNSquare(arr);

    }
    public static void methodNSquare(int arr[]){
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
        int count = 0;
        for(int i=0;i<arr.length;i++){
            count = 0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] < arr[j])
                    count++;
            }
            System.out.print(count + " ");
        }
    }
}
