# DP

- 问题：暴力的递归解法 -> 带备忘录的递归解法 -> 迭代的动态规划解法
- 思考：找到状态和选择 -> 明确 dp 数组/函数的定义 -> 寻找状态之间的关系
- 动态规划问题的一般形式就是求最值
- 求解动态规划的核心问题是穷举

## Steps

[link](https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie)

- 存在「重叠子问题」
- 具备「最优子结构」
- 正确的「状态转移方程」
  - 明确 base case -> 明确「状态」-> 明确「选择」 -> 定义 dp 数组/函数的含义

带备忘录的递归解法 -> 自顶向下

动态规划 -> 自底向上

## Examples

### Fib numbers

```java
// Base case : n = 0 return 0; n = 1 return 1
// 状态转移方程
// fn = 0 when n < 0
// fn = 1 when n = 1
// fn = fn-1 + fn-2 when n > 1


// 基础递归 O(2^n)
/*
class Solution {
    public int fib(int N) {
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fib(N - 1) + fib (N - 2);
        }
    }
}
*/

// memorization from top down 
// 带有备忘录的自顶向下 优化重复子问题
// O(n)
/*
class Solution {
    public int fib(int N) {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, 0);
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (memo[N] == 0) {
            return memo[N] = fib(N - 1) + fib(N - 2);
        } else {
            return memo[N];
        }
    }
}
*/

// DP from bottom to top with memo
// 循环
/*
class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        } else {
            int[] dp = new int[N + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= N; i ++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[N];
        }
    }
}
*/

// DP from bottom to top with memo
// 循环
// space OPT 仅仅维护两个变量

class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        } else {
            int prev = 0;
            int curr = 1;
            int sum;
            for (int i = 2; i <= N; i ++) {
                sum = prev + curr;
                prev = curr;
                curr = sum;
            }
            return curr;
        }
    }
}
```

### Coin Change

```java
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
```

