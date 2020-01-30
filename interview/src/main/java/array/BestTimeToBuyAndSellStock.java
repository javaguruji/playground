package array;

/**
 * @author badrikant.soni
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        // let say buy stock on day2 (1) and sell it on day5 (6)
        // max profit = 6 - 1 = 5

        System.out.println(maxProfitSingleTraversal(prices));
        System.out.println(maxProfitWithTwiceTraversal(prices));
        System.out.println(maxProfitLeetCode(prices));
        System.out.println(maxProfitWithMultiSell(prices));
        System.out.println(maxProfitWithMultiSell1(prices));

    }

    // Brute Force
    // We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array.
    // Also, the second number (selling price) must be larger than the first one (buying price).
    public int maxProfitBruiteForceApproach(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    public static int maxProfitSingleTraversal(int[] prices) {

        // base case
        if (prices.length == 0) {
            return 0;
        }

        // assume first element of array is minimum
        int minStockPrice = prices[0];

        // assume profit
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // find minimum stock price
            if (prices[i] < minStockPrice) {
                minStockPrice = prices[i];
            } else {
                int diff = prices[i] - minStockPrice;
                maxProfit = Math.max(maxProfit, diff);
            }
        }

        return maxProfit;
    }

    private static int maxProfitWithTwiceTraversal(int[] prices){

        int minStockPrice = prices[0];
        int maxProfit = 0;

        // In the first traversal, find the minimum stock price
        for(int i = 0; i < prices.length -1 ; i++){
            if(prices[i] < minStockPrice){
                minStockPrice = prices[i];
            }
        }

        // In the second traversal, find the max profit(difference between selling price & minimum stock price)
        for(int i = 1; i < prices.length ; i++){
            int profit = prices[i] - minStockPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static int maxProfitLeetCode(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
    // Input: [7,1,5,3,6,4]
    // Output: 7
    // Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    //             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    //
    //
    //
    // The key point is we need to consider every peak immediately following a valley to maximize the profit.
    // In case we skip one of the peaks (trying to obtain more profit),
    // we will end up losing the profit over one of the transactions leading to an overall lesser profit.
    public static int maxProfitWithMultiSell1(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static int maxProfitWithMultiSell(int[] prices) {

        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                maxprofit = maxprofit + prices[i]  - prices[i-1];
            }
        }

        return maxprofit;
    }
}
