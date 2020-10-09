// Base case: when amount = 0 we only need 0 coin
// 状态转移 
// fn = -1 when amount < 0
// fn = 0 when amount = 0
// fn = min{dp(n - coin) + 1 | coin in coins} when amount > 0


// memo recursion
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        // base case: when amount = 0, coinNum = 0
        memo[0] = 0;
        return coinChangeHelper(coins, amount, memo);
    }
    
    private int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        // lookup in memo
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        } 
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeHelper(coins, amount - coin, memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            } 
        }
        memo[amount] = min == (Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }
}
*/

// DP
// Dp array, index indicate the amount, that element indicates the min number of coins that needed to fulfill amount
// dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        // base case
        dp[0] = 0; // when amount = 0, coin number is 0 too
        
        // 第一个for循环 遍历amount 从0到11
        for (int i = 1; i <= amount; i ++) {
            // 第二个循环 遍历每个金额 里面尝试每一个币种
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == max) ? -1 : dp[amount];
    }
}