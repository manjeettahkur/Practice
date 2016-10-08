package Matrix;

/**
 * Created by laxminarayanvarma on 28/8/16.
 */
public class Rotate90Degree {
    public static void printArray(int [][]arr){
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String [] args){
        int [][]arr = {{1,2,3},{4,5,6},{7,8,9}};
        printArray(arr);
        rotateArray(arr);


    }
    public static void rotateArray(int [][]arr){
        int [][]arrRotated = {{0,0,0},{0,0,0},{0,0,0}};
        printArray(arrRotated);
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
               arrRotated[j][2-i] = arr[i][j];
        }
        printArray(arrRotated);

    }
}
