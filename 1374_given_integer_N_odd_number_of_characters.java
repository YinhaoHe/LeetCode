class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);
        while (sb.length() < n - 1) {
            sb.append('a');
        }
        if (n % 2 == 0) {
            sb.append('b');
        } else {
            sb.append('a');
        }
        return sb.toString();
    }
} 