package test;

/**
 * Created by laxminarayanvarma on 30/12/16.
 */
public class Question1 {
    public static void main(String [] args){
        char []arr = {'a','b','x','c','c','d','e','f','g'};
        int []index = {2,6,7};

        for(int x : index){
            arr[x] = ' ';
        }

        int i = 0;
        int j = -1;
        while(i<arr.length){

            while( i < arr.length && arr[i] != ' ' ){
                i++;
            }
            while(i<arr.length && arr[i] == ' ' ){
                if (j == -1)
                    j = i;

                i++;
            }
            while( i < arr.length && arr[i] != ' '){
                swap(arr,i,j);
                i++;
                j++;
            }
        }
        for(Character a: arr){
            System.out.println(a);
        }
    }

    static void swap(char arr[],int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
