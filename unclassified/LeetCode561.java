// 每一个pair中，小的会cancel大的 所以先排序 然后相邻的两个pair让小的尽可能cancel小的“大的数字” 因此来获得最大
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}