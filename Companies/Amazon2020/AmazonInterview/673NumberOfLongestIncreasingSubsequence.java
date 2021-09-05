/*
这道题给了我们一个数组，让求最长递增序列的个数，题目中的两个例子也很好的说明了问题。
那么对于这种求极值的问题，直觉告诉我们应该要使用动态规划 Dynamic Programming 来做。
其实这道题在设计 DP 数组的时候有个坑，如果将 dp[i] 定义为到i位置的最长子序列的个数的话，
则递推公式不好找。但是如果将 dp[i] 定义为以 nums[i] 为结尾的递推序列的个数的话，
再配上这些递推序列的长度，将会比较容易的发现递推关系。
这里用 len[i] 表示以 nums[i] 为结尾的递推序列的长度，
用 cnt[i] 表示以 nums[i] 为结尾的递推序列的个数，初始化都赋值为1，只要有数字，
那么至少都是1。然后遍历数组，对于每个遍历到的数字 nums[i]，
再遍历其之前的所有数字 nums[j]，当 nums[i] 小于等于 nums[j] 时，
不做任何处理，因为不是递增序列。反之，则判断 len[i] 和 len[j] 的关系，
如果 len[i] 等于 len[j] + 1，说明 nums[i] 这个数字可以加在以 nums[j] 结尾的递增序列后面，
并且以 nums[j] 结尾的递增序列个数可以直接加到以 nums[i] 结尾的递增序列个数上。
如果 len[i] 小于 len[j] + 1，说明找到了一条长度更长的递增序列，
那么此时将 len[i] 更新为 len[j]+1，并且原本的递增序列都不能用了，
直接用 cnt[j] 来代替。在更新完 len[i] 和 cnt[i] 之后，要更新 mx 和结果 res，
如果 mx 等于 len[i]，则把 cnt[i] 加到结果 res 之上；如果 mx 小于 len[i]，
则更新 mx 为 len[i]，更新结果 res 为 cnt[i]，参见代码如下：
*/


class Solution {
    public int findNumberOfLIS(int[] nums) {
        int res = 0, max = 0, N = nums.length;
        if (N <= 1) return N;
        
        int[] len = new int[N]; // length of LIS ending in num[i]
        int[] cnt = new int[N]; // number of LIS ending in num[i]
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);
        
        // loop from nums[0] to the end
        for (int i = 0; i < N; ++ i) {
            // loop from nums[0] to nums[i]
            for (int j = 0; j < i; ++ j) {
                if (nums[i] <= nums[j]) continue; // not increasing sequence
                if (len[i] == len[j] + 1) cnt[i] += cnt[j]; 
                else if (len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];
                }
            }
            max = Math.max(max, len[i]);
        }
        
        for (int i = 0; i < N; ++ i) {
            if (max == len[i]) res += cnt[i];
        }
        return res;
    }
}