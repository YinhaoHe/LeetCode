class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null && nums.length == 0)
            return;
        // Find the first ascending order number
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i --;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // Find the first number bigger than nums[i] -> j
            while (j >= 0 && nums[j] <= nums[i]) {
                j --;
            }
            swap (nums, i, j);
        }
        // reverse all numbers behind i+1
        int p = i + 1;
        int q = nums.length - 1;
        while (p < q) {
            swap (nums, p++, q--);
        }
    }
    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}