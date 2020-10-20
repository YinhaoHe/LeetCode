// Recursive with memo
/*
class Solution {
    
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    private int recursiveWithMemo(int index, String str) {
        // if index at the end of the string
        // 意味着这个index只有最后一位数字 一定可以对应decode 所以return 1
        if (index == str.length()) {
            return 1;
        }
        
        // if char at index equals 0; it cannot be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }
        
        if (index == str.length() - 1) {
            return 1;
        }
        
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str);
        }
        
        memo.put(index, ans);
        
        return ans;
    }
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return recursiveWithMemo(0, s);
    }
}
*/

// Base case : dp[0] = 1; when string is empty, we have one way to decode
// dp[i] = 0 if s[i] == '0'
// dp[i] = dp[i - 1] if s[i] valid but s[i]s[i - 1] not valid
// dp[i] = dp[i - 2] if s[i]s[i - 1] valid but s[i] not valid
// dp[i] = dp[i - 1] + dp[i - 2] if s[i] and s[i]s[i - 1] both valid


class Solution {
    public int numDecodings(String s) {
        // edge case 
        // if string is null or first char of string is '0' 
        // we cannot decode, return 0
        if (s == null || s.charAt(0) == '0') {
            return 0;
        }
        
        if (s.length() == 1) return 1;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        for (int i = 1; i < dp.length; ++ i) {
            if (s.charAt(i - 1) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }
            
            if (i > 1 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6' && s.charAt(i - 1) >= 0)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}


/*
// 太牛逼了 膜拜
class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int a = 1, b = 1, n = s.length();
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '0') a = 0;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                a = a + b;
                b = a - b;
            } else {
                b = a;
            }
        }
        return a;
    }
}
*/