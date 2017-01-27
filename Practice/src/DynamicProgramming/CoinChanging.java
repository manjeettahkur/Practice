package DynamicProgramming;

/**
 * Created by laxminarayanvarma on 11/10/16.
 */
public class CoinChanging {
    public int numberOfSolutions(int total, int coins[]){
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        printArray(temp);
        return temp[coins.length][total];
    }
    public static void main(String args[]){
        CoinChanging cc = new CoinChanging();
        int total = 15;
        int coins[] = {3,4,6,7,9};
        System.out.println(cc.numberOfSolutions(total, coins));

    }
    public void printArray(int [][]arr){
        for(int []a:arr){
            for(int x:a){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
