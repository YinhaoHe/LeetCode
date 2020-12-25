 class Solution {
    public int strStr(String haystack, String needle) {
        int lh = haystack.length(), ln = needle.length();
        if (ln == 0) return 0;
         
        int ph = 0; 
         
        while (ph < lh - ln + 1) {
            // find the first position of ph
            while (ph < lh - ln + 1 && haystack.charAt(ph) != needle.charAt(0)) {
                ++ ph;
            } 

            int curLength = 0, pn = 0;
            while (ph < lh && pn < ln && haystack.charAt(ph) == needle.charAt(pn)) {
                ++ ph;
                ++ pn;
                ++ curLength;
            }
             
            if (curLength == ln) {
                return ph - ln;
            }
            ph = ph - curLength + 1;
        }
        return -1;
    }
}