package Array;

/**
 * Created by laxminarayanvarma on 3/2/17.
 */
public class NextHighPalindrom {
    static void generateNextPalindromeUtil (int num[], int n )
    {
        int mid = n/2;

        boolean leftsmaller = false;
        int i = mid - 1;

        int j = (n % 2 == 1)? mid + 1 : mid;

        while (i >= 0 && num[i] == num[j])
            i--;j++;


        if ( i < 0 || num[i] < num[j])
            leftsmaller = true;

        while (i >= 0)
        {
            num[j] = num[i];
            j++;
            i--;
        }

        if (leftsmaller == true)
        {
            int carry = 1;
            i = mid - 1;

            if (n%2 == 1)
            {
                num[mid] += carry;
                carry = num[mid] / 10;
                num[mid] %= 10;
                j = mid + 1;
            }
            else
                j = mid;

            while (i >= 0)
            {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j++] = num[i--];
            }
        }
    }

    static void generateNextPalindrome( int num[], int n )
    {
        int i;
        System.out.println("Next palindrome is:");
        if( AreAll9s( num, n ) ) {
            System.out.print( "1 ");
            for( i = 1; i < n; i++ )
                System.out.print( "0 " );
            System.out.print( "1" );
        }else {
            generateNextPalindromeUtil ( num, n );
            printArray (num, n);
        }
    }

    static boolean AreAll9s( int num[], int n ) {
        int i;
        for( i = 0; i < n; ++i )
            if( num[i] != 9 )
                return false;
        return true;
    }

    static void printArray(int arr[], int n)
    {
        int i;
        for (i=0; i < n; i++)
            System.out.print(arr[i] +" ");
        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        generateNextPalindrome( arr, arr.length );

    }
}
