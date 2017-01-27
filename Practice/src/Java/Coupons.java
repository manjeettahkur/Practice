package Java;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 15/10/16.
 */
public class Coupons {


        public static void main(String args[] ) throws Exception {

            Scanner s = new Scanner(System.in);
            int N = s.nextInt();
            int Q = s.nextInt();

            boolean arr[] = new boolean[N];
            for (int i = 0; i < Q; i++) {
                int x = s.nextInt();
                arr[x-1] = true;
                printArr(arr);
                System.out.println(printLength(arr));
            }



        }
    public static void printArr(boolean arr[]){
        for(boolean x : arr){
            if(x)
                System.out.print(1+" ");
            else
                System.out.print(0+" ");

        }
        System.out.println();
    }
   /* public static int printLength(boolean arr[]){
        int count = 0;
        int lenght = 0;
        int maxLenght = 0;
        int start;
        int end;
        boolean first = false;
        int firstIndex = 0;
        boolean last = false;
        int lastIndex = 0;
        for(int i =0;i<arr.length;i++){
            if(!first && arr[i])
                firstIndex = i;
        }
        for(int i =arr.length-1;i>-1;i++){
            if(!last && arr[i])
                lastIndex = i;
        }
        if(first == last){
            if(firstIndex ==0 || firstIndex == arr.length -1)
                lenght = 2;
            else
                lenght = 3;
        }
        else{
            start = firstIndex;
            end = lastIndex;
            for (int i = firstIndex;i< lastIndex ;i++){
                if(arr[i]== true && arr[i+1] == true ){
                    if(count > maxLenght){
                        maxLenght = count;
                        if(firstIndex == 0 || lastIndex == 0)

                    }



                }else{
                    count++;
                }
            }
        }

        return lenght;
    }*/
   public static int printLength(boolean arr[]){
       int count = 0;
       int lenght = 0;
       int maxLenght = 0;
       int start;
       int end;
       boolean first = false;
       int firstIndex = 0;
       boolean last = false;
       int lastIndex = 0;
       for(int i =0;i<arr.length;i++){
           if(!first && arr[i]){
               firstIndex = i;
               first = true;
           }

       }
       for(int i =arr.length-1;i>-1;i--){
           if(!last && arr[i]){
               lastIndex = i;
               last = true;
           }

       }
       if(firstIndex == lastIndex){
           if(firstIndex ==0 || firstIndex == arr.length -1)
               lenght = 2;
           else
               lenght = 3;
       }
       else{
           start = firstIndex;
           end = lastIndex;
           System.out.println(firstIndex + " " + lastIndex);
           for (int i = firstIndex;i< lastIndex ;i++){
               if(arr[i]== true && arr[i+1] == true ){

               }else{
                   count++;
               }
           }
           count++;
           if(firstIndex != 0)
               count++;
           if(lastIndex != arr.length -1)
               count++;
           lenght = count;
       }

       return lenght;
   }
    }


