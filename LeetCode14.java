class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return ""; // edge case
        // 横向比较 先找出第一个和第二个的prefix然后依次和下一个比较
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i ++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix == null) return "";
            }
        }
        return prefix;
    }
}