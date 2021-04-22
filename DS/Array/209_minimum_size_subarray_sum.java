class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0; // start of window
        int size = 0; // size of window -- answer
        int sum = 0; 
        int result = Integer.MAX_VALUE;
    
        for (int end = 0; end < nums.length; ++ end) {
            // end -- the end of window
            sum += nums[end];
            
            while (sum >= target) {
                size = end - start + 1;
                result = size < result ? size : result;
                sum -= nums[start ++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}