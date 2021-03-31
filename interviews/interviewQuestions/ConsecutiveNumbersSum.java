/*

Consecutive Numbers Sum

Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

*/


class Solution {
    public int consecutiveNumbersSum(int N) {
        int result = 0;
        for (int i = 0; i < N; ++i) {
            if (i * (i + 1) / 2 > N) {
                break;
            }
            int as = N - (i + 1) * i / 2;
            // 不能整除继续
            if (as % (i + 1) != 0)continue;
            // 开始的数字a大于0
            if (as / (i + 1) > 0){
                ++result;
            } 
        }

        return result;

    }
}