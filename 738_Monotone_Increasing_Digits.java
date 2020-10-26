/*
给定一个数字 找到比这个数字小的 最大的 按位 从左到右依次递增的一个数字
*/

class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i - 1] <= S[i]) i ++;
        while (i > 0 && i < S.length && S[i - 1] > S[i]) S[--i] --;
        for (int j = i + 1; j < S.length; ++ j) S[j] = '9';
        
        return Integer.parseInt(String.valueOf(S));
    }
}