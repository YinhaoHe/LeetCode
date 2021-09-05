class Solution {
    public boolean isAnagram(String s, String t) {
        // corner case
        if (s.length() != t.length()) return false;
        
        int[] numOfChar = new int[26];
        for (int i = 0; i < s.length(); ++ i) {
            numOfChar[s.charAt(i) - 'a'] ++;
            numOfChar[t.charAt(i) - 'a'] --;
        }
        for (int count : numOfChar) {
            if (count != 0) return false;
        }
        return true;
    }
}