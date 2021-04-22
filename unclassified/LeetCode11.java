class Solution {
    public int maxArea(int[] height) {
        int left = 0; // left pointer
        int right = height.length - 1; // right pointer
        int maxArea = 0, area = 0;
        
        while(left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
            
        }
        return maxArea;
    }
}