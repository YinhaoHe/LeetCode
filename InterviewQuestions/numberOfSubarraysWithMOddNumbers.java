/*

Number of subarrays with m odd numbers

Given an array of n elements and an integer m, we need to write a program to find the number of contiguous subarrays in the array which contains exactly m odd numbers.

*/

class Solution {
    private boolean isOdd (int x) {
        return (x & 1) == 1;
    }
    
    public int numberOfSubarrays(int[] nums, int k) {
        // Use sliding window to count the number of odd numbers
		// only thing that matters is the number of odd numbers 
        int result = 0; // Initialize result = 0
        // Use a list to store the index of the odd number at first
		List<Integer> oddIndex = new ArrayList<>();
        
		oddIndex.add(-1); // Set the left border
		int len = nums.length;
		for (int i = 0; i < len; i ++) {
			if (isOdd(nums[i])) {
				oddIndex.add(i);
			}
		}
		oddIndex.add(len); // Set the right border
        
		// Need to find how many possibility of the left side and right side
		// There are oddIndex.get(i) - oddIndex.get(i - 1) possible conditions on the left side
		// There are oddIndex.get(i + k) - oddIndex.get(i + k - 1) possible conditions on the right side
        // result is left time right

		for (int i = 1; i + k < oddIndex.size(); i ++) {
			result += (oddIndex.get(i) - oddIndex.get(i - 1)) * (oddIndex.get(i + k) - oddIndex.get(i + k - 1));
		}
		return result;
    }
}