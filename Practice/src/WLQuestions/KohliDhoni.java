package WLQuestions;

/**
 * Created by laxminarayanvarma on 23/9/16.
 * http://www.geeksforgeeks.org/counting-inversions/
 * https://www.careercup.com/question?id=5706718039244800
 */
public class KohliDhoni {
    public static void main(String args[]){
        int [] first = {3,1,2,4,5,6};
        int [] second = {3,2,4,1,6,5};
        System.out.println(CompatibilityChecker(first,second));
     }

    public static int CompatibilityChecker(int [] first, int [] second)
    {
        int relativeDifference = 0;
        for (int i = 0; i < first.length; i++)
        {
            if (first[i] != second[i])
            {
                int j = i + 1;
                while (first[i] != second[j])
                {
                    j++;
                }
                while (j != i)
                {
                    Swap(second, j, j - 1);
                    j--;
                    relativeDifference++;
                }

            }
        }
        return relativeDifference;
    }
    public static void Swap(int [] arr,int x,int y){
        System.out.println("Swap pair : "+ arr[x] + " "+arr[y]);
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
