class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i ++) {
            // 奇数number的回文串
            int len1 = palindrome(s, i, i);
            // 偶数number的回文串
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    // find the length of the palindrome string
    private int palindrome (String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }
}