class Solution {
    public void reverseString(char[] s) {
        //define left and right pointer
        int left = 0;
        int right = s.length - 1;
        char tmp;
        
        //双指针循环调整位置
        while(left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            
            left++;
            right--;
        }
    }
}