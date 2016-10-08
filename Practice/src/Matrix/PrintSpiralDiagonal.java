package Matrix;

/**
 * Created by laxminarayanvarma on 27/8/16.
 */
public class PrintSpiralDiagonal {

    public static void main(String [] args){
        int [][]arr = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("Printing spiral along diagonal");
        printSpiral(arr);

    }
    public static void printSpiral(int [][]arr){
        for(int i=0;i<5;i++){
            if(i%2 == 0){
                for(int x=i;x<i+1;x--){
                    for(int y=0;y<i+1;y++){
                        if(x+y == i && x <3 && y <3)
                            System.out.print(arr[x][y]+",");
                    }
                }
            }
            if(i%2 == 1){
                for(int x=0;x<i+1;x++){
                    for(int y=i;y>-1;y--){
                        if(x+y == i && x <3 && y <3)
                            System.out.print(arr[x][y]+",");

                    }
                }
            }
            System.out.println();
        }
    }
}
