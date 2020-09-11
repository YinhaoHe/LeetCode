class Solution {
    public double myPow(double x, int n) {
        double s = n != 0 ? myPow(x, n / 2) : 1;
        x = n % 2 == 0 ? 1 : x;
        return n > 0 ? x * s * s : 1 / x * s * s;
    }
}