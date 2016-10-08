package Matrix;

/**
 * Created by laxminarayanvarma on 28/8/16.
 */
public class PrintSpiralRowColume {
    public static void main(String [] args){
        int [][]arr = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("Printing spiral along diagonal");
        int rowCount = 3;
        int columeCount = 3;
        printRowSpiral(arr, rowCount, columeCount);
        printColumeSpiral(arr, columeCount, columeCount);
    }
    public static void printRowSpiral(int [][]arr, int rowCount, int columeCount){
        System.out.println("Printing Row Spiral");
        for(int row = 0;row<rowCount;row++){
            if (row%2==0){
                for(int colume = 0;colume<columeCount;colume++)
                    System.out.print(arr[row][colume]+" ");
            }
            if(row%2==1){
                for(int colume = columeCount-1;colume>-1;colume--)
                    System.out.print(arr[row][colume]+" ");
            }
            System.out.println();
        }
    }
    public static void printColumeSpiral(int [][]arr, int rowCount, int columeCount){
        System.out.println("printing Colume Spiral");
        for(int colume = 0;colume<columeCount;colume++){
            if (colume%2==0){
                for(int row = 0;row<rowCount;row++)
                    System.out.print(arr[row][colume]+" ");
            }
            if(colume%2==1){
                for(int row = rowCount-1;row>-1;row--)
                    System.out.print(arr[row][colume]+" ");
            }
            System.out.println();
        }
    }
}
