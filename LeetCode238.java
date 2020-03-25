class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; //nums length
        int leftProduct[] = new int[len];
        int rightProduct[] = new int[len];
        int ans[] = new int[len];
        
        leftProduct[0] = 1;
        for (int i = 1; i < len; i ++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1]; //left product of every element in array nums
        }
        rightProduct[len - 1] = 1;
        for (int i = len - 2; i >= 0; i --) { //Be sure i >= 0 because you will never reach ans[0] if not i >= 0
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1]; //right product of every element in array nums
        }
        for (int i = 0; i < len; i ++) {
            ans[i] = leftProduct[i] * rightProduct[i];
        }
        return ans;
    }
}