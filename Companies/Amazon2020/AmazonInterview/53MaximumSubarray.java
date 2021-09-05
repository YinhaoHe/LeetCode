class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++ i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for (int i = 1; i < n; ++ i) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}