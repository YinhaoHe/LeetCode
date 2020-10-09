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