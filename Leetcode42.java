class Solution {
    public int trap(int[] height) {
        int res = 0, max = 0, n = height.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.min(dp[i], max);
            max = Math.max(max, height[i]);
            if (dp[i] - height[i] > 0) res += dp[i] - height[i];
        }
        return res;
    }
}