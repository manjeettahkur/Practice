package WLQuestions;

/**
 * Created by laxminarayanvarma on 22/9/16.
 * http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 * Time Complexity: O(n2^n)
 */
public class AllPossibleSubSet {
    public static void main(String []args){
        int arr [] = {1,2,3,4,5,6,7};
        printSubsets(arr);

    }
    static void printSubsets(int set[])
    {
        int n = set.length;
        // Run a loop for printing all 2^n
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
            System.out.println("}");
        }
    }

}
