class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        int n = s.length(); // string length
        int left = 0; // sliding window 左指针
        int right = 0; // sliding window 右指针
        int ans = 0; // initate ans = 0
        
        // define HashSet to store the string and find the duplicate
        HashSet<Character> set = new HashSet<>();
        while(left < n && right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++)); // 若不存在则放入HashSet并且扩大sliding window
                // window lengh is the length of string
                ans = Math.max(ans, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return ans;
    }
}