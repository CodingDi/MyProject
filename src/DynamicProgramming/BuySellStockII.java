package DynamicProgramming;

public class BuySellStockII {

        public int maxProfit(int[] prices) {
            int profit = 0;
            int minPrice = Integer.MAX_VALUE;

            for (int i = 0; i < prices.length; i++) {

                if (prices[i] > minPrice) {
                    profit += prices[i] - minPrice;
                }


                minPrice = prices[i];

            }
            return profit;
        }

}
