class Solution {
    public int strStr(String haystack, String needle) {
        int hL = haystack.length();
        int nL = needle.length();
        if (nL == 0) return 0;
        
        int ph = 0;
        while (ph < hL - nL + 1) {
            
            // find the first matching char 
            while(ph < hL - nL + 1 && haystack.charAt(ph) != needle.charAt(0)) ph ++;

            int pn = 0, currLength = 0;
            // from the first matching char, compare the rest of needle to haystack
            while(ph < hL && pn < nL && haystack.charAt(ph) == needle.charAt(pn)) {
                ph ++;
                pn ++;
                currLength ++;
            }
            if (currLength == nL) return ph - nL;

            ph = ph - currLength + 1;
        }
        return -1;
    }
}