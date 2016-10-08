package WLQuestions;

/**
 * Created by laxminarayanvarma on 26/9/16.
 */
public class MazeMovement {
    static int N = 3;
    public static void main(String []args){
        int maze[][]  =  new int[][]{{5,6,3},{6,7,2},{3,2,1}};
        solveMaze(maze);
    }

    public static void solveMaze(int [][] maze){
        int xMove[]={1,0,-1,0};
        int yMove[]={0,1,0,-1};
        System.out.println(isSolveMazeUtil(maze,1,1,1,xMove,yMove));
    }
    static int isSolveMazeUtil(int maze[][],int x,int y,int movei,int xMove[],int yMove[]){
        int next_x,next_y;
        int ans =0;
        if(x==0 && y==0 && movei<=N*N)
            return 1;

        if(movei>N*N)
            return 0;
        for(int i=0;i<4;i++){
            next_x = x + xMove[i];
            next_y = y + yMove[i];
            int pre = maze[x][y];
            if(isSafe(maze,next_x,next_y,pre) == true){
                int k;
                k = isSolveMazeUtil(maze,next_x,next_y,movei+1,xMove,yMove);
                if(k!=0)
                    ans+=k;
            }
        }
        return ans;
    }
    static boolean isSafe(int maze[][], int x, int y,int pre)
    {
        if(x >= 0 && x < N && y >= 0 && y < N && maze[x][y]>0 && maze[x][y]<pre)
            return true;

        return false;
    }
}
