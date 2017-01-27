package company;

import java.util.Scanner;

/**
 * Created by laxminarayanvarma on 4/1/17.
 */
public class AmazonQ1 {


    static boolean isSafe(int M[][], int row, int col,
                   boolean visited[][],int Row,int Colume)
    {
        return (row >= 0) && (row < Row) &&
                (col >= 0) && (col < Colume) &&
                (M[row][col]==1 && !visited[row][col]);
    }

    static int DFS(int M[][], int row, int col, boolean visited[][], int Row, int Colume)
    {
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int k = 0; k < 8; ++k){
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited,Row,Colume) )
               return 1 + DFS(M, row + rowNbr[k], col + colNbr[k], visited,Row,Colume);
        }

        return 0;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][] {{1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 1, 0}
        };
        Scanner sc = new Scanner(System.in);

        int Row = sc.nextInt();
        int Colume = sc.nextInt();
        int matrix[][] = new int [Row][Colume];
        for(int i = 0 ; i<Row;i++){
            for(int j =0;j<Colume;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println( countIslands(matrix,Row,Colume));
    }

    public static int countIslands(int Mat[][],int Row,int Colume){
            boolean visited[][] = new boolean[Row][Colume];


        int max = 0;
        int result = 0;
        boolean flag = true;
        for (int i = 0; i < Row; ++i)
            for (int j = 0; j < Colume; ++j)
                if(Mat[i][j] == 0){
                    flag = false;
                    break;
                }

        if(!flag) {
            for (int i = 0; i < Row; ++i)
                for (int j = 0; j < Colume; ++j)
                    if (Mat[i][j] == 1 && !visited[i][j]) {
                        result = 1 + DFS(Mat, i, j, visited, Row, Colume);
                        if (result > max)
                            max = result;
                    }
        }else{
            max = Row*Colume;
        }
            return max;
        }
}
