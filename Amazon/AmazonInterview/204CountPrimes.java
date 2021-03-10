class Solution {
    
    // 1. 0 and 1 is not prime
    // 2. find 
    
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        
        // 默认所有的元素值都会设置为false，boolean初始值为false
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i * i < n; ++ i) {
            if(!notPrime[i]) {
                // 如果i是一个质数， 将i的倍数设置为非质数,
                // i 的 j 倍设为非质数
                for (int j = 2; j * i < n; ++ j) {
                    notPrime[i * j] = true;
                }
            }
        }
        int count = 0;
        for (boolean b : notPrime) {
            if (!b) count ++;
        }
        return count;
    }
    
    /* Toooooo slow
    public int countPrimes(int n) {
        if (n < 3) return 0;
        if (n == 3) return 1;
        int count = 0;
        
        for (int i = 2; i < n; i ++) {
            if(isPrime(i)) count ++;
        }
        return count;
    }
    
    public boolean isPrime(int n) {
        for (int i = 2; i < n; ++ i) {
            if (n % i == 0) return false;
        }
        return true;
    }
    */
}