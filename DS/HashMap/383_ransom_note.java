class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] maga = new int[26];
        for (int i = 0; i < magazine.length(); ++ i) {
            char c = magazine.charAt(i);
            maga[c - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); ++ i) {
            char c = ransomNote.charAt(i);
            if (--maga[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}