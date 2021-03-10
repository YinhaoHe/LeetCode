class Solution {
    
    // O(NlogN) 没啥意思
    /*
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        for (int i =0; i < N; ++ i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
    */ 
    
    // two pointers
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        int left = 0;
        int right = N - 1;
        
        for (int i = N - 1 ; i >= 0 ; -- i) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right --;
            } else {
                square = nums[left];
                left ++;
            }
            ans[i] = square * square;
        }
        return ans;
    }
}