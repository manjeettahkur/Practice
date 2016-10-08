package WLQuestions;

/**
 * Created by laxminarayanvarma on 26/9/16.
 */
public class LongestPalindrome {
    int max(int x , int y)
    {
        return (x>y)? x:y;
    }

    int lps(char[] a ,int i , int j)
    {
        if(i==j) //If only 1 letter
        {
            return 1;
        }
        if(a[i] == a[j] && (i+1) == j) // if there are 2 character and both are equal
        {
            return 2;
        }
        if(a[i] == a[j]) // If first and last char are equal
        {
            return lps(a , i+1 , j-1) +2;
        }
        return max(lps(a,i+1 ,j),lps(a,i,j-1));
    }

    public static void main(String[] args)
    {
        String s = "NAMAN IS NAMxhgfhgf";
        LongestPalindrome p = new LongestPalindrome();
        char[] c = s.toCharArray();
        System.out.print("Length of longest seq is : " + p.lps(c,0,c.length-1));
    }
}
