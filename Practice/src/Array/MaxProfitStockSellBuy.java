package Array;

/**
 * Created by laxminarayanvarma on 25/9/16.
 */
public class MaxProfitStockSellBuy {

        static int maxProfit(int price[], int n)
        {
            int profit[] = new int[n];
            for (int i=0; i<n; i++)
                profit[i] = 0;
            int max_price = price[n-1];
            for (int i=n-2;i>=0;i--)
            {
                // max_price has maximum of price[i..n-1]
                if (price[i] > max_price)
                    max_price = price[i];

                profit[i] = Math.max(profit[i+1], max_price-price[i]);
            }

            for (int i=0; i<n; i++)
                System.out.print(profit[i]+" ");
            int min_price = price[0];
            for (int i=1; i<n; i++)
            {
                // min_price is minimum price in price[0..i]
                if (price[i] < min_price)
                    min_price = price[i];

                profit[i] = Math.max(profit[i-1], profit[i] +
                        (price[i]-min_price) );
            }
            System.out.println();
            for (int i=0; i<n; i++)
                System.out.print(profit[i]+" ");
            int result = profit[n-1];
            System.out.println();
            return result;
        }


        public static void main(String args[])
        {
            int price[] = {2, 30, 15, 10, 8, 25, 80};
            for (int i=0; i<price.length; i++)
                System.out.print(price[i]+" ");
            int n = price.length;
            System.out.println();
            System.out.println("Maximum Profit = "+ maxProfit(price, n));
        }

    }

