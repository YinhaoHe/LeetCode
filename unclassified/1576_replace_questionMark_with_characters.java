class Solution {
    public String modifyString(String s) {
        char[] sAr = {'a', 'b', 'c'};
        char[] S = s.toCharArray();
        int len = S.length;
        
        char left = ' ';
        char right = ' ';
        
        for (int i = 0; i < len; ++ i) {
            if (Character.isAlphabetic(S[i])) continue;
            
            if (i > 0) left = S[i - 1];
            if (i < len - 1) right = S[i + 1];
            
            for (char sar : sAr) {
                if (left != sar && right != sar) {
                    S[i] = sar;
                    break;
                }
            }
        }
        
        return new String(S);
    }
}