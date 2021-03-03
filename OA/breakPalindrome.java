import java.util.Scanner;
class Solution {
    public static String breakPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        if (n == 1)
            return "";
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        chars[n - 1] = 'b';
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        String res = breakPalindrome(s);
        System.out.println(res);
    }
}