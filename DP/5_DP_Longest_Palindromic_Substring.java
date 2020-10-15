/*
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
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
*/


// Base case : f(n, n) = T
// f(n, n + 1) = (Si == Si+1)

// dp[i][j] = true when i == j
// dp[i][j] = s[i] == s[j] when i == j + 1
// dp[i][j] = s[i] == s[j] && dp[i-1][j+1] when i - j >= 2

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        int n = s.length();
        char[] sArr = s.toCharArray();
        int max = 1;
        int start = 0;
        int end = 0;
        boolean dp[][] = new boolean[n][n];
        
        // initial one character substring
        for (int i = 0; i < n; i ++) {
            dp[i][i] = true;
            start = i;
            end = i;
            max = 1;
        }
        
        // two characters
        for (int i = 0; i < n - 1; i ++) {
            if (sArr[i] == sArr[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
                max = 2;
            }
        }
        
        // three characters and more than three characters
        // 用长度进行循环
        for (int len = 3; len <= n; len ++) {
            for (int i = 0; i < n - len + 1; i ++) {
                // i to j 中间有len个characters 用len循环 依次设定对应的j
                int j = i + len - 1;
                if (sArr[i] == sArr[j] && dp[i + 1][j - 1]) {
                    if (max > len)
                        max = len;
                    start = i;
                    end = j;
                    dp[i][j] = true;
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}

