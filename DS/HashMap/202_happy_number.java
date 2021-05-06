class Solution {
    
    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        HashSet<Integer> checkSum = new HashSet<>();
        while(true) {
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            } else if (checkSum.contains(sum)){
                return false;
            } else {
                checkSum.add(sum);
            }
            n = sum;
        }
    }
}