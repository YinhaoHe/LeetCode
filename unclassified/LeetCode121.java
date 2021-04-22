DP not needed by ok
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
//         //dp 
//         int[][] dp = new int[prices.length][prices.length];
//        // dp[0][0] = 0; // profit from day 0 to last day
        
//         for(int i = 0; i < prices.length; i ++) {
//             for(int j = i + 1; j < prices.length; j ++) {
//                 dp[i][j] = Math.max(prices[j] - prices[i], maxProfit);
//                 if (dp[i][j] > maxProfit)
//                     maxProfit = dp[i][j];
//             }
//         }
        
//         return maxProfit;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < minprice) {
                minprice = prices[i]; // update min price
            }
            else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice; // update the max profit 
            }
        }
        return maxprofit;
    }
}