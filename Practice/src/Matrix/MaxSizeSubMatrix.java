package Matrix;

/**
 * Created by laxminarayanvarma on 28/8/16.
 */
public class MaxSizeSubMatrix {
    public static void printArray(int [][]arr){
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

        String str = "";
        str.compareTo("");
        System.out.println();
    }
    public static void main(String [] args){
        int [][]arr = {{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
        printArray(arr);
        maxSizeSubMatrixWithAllOne(arr);

    }
    public static void maxSizeSubMatrixWithAllOne(int [][]arr){
        int countArray[][] = {{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
        for(int i=1;i<5;i++) {
            for (int j = 1; j < 5; j++)
                if(arr[i][j] == 1)
                    countArray[i][j] = maxValue(countArray[i-1][j-1],countArray[i-1][j],countArray[i][j-1]);
        }
        printArray(countArray);
        int size = 0;
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++)
                if (countArray[i][j] > size)
                    size = countArray[i][j];
        }
        System.out.println("Max size sub matrix is of size : " + size);
    }
    public static int maxValue(int p,int q,int r){
        int min = p;
        if(q<min)
            min=q;
        if(r<min)
            min=r;
        return min+1;
    }
}
