import java.util.*;

public class BinaryDivisible {
    public static int binaryDivisible(int n, String biStr) {
        String[] arr = biStr.trim().split(",");
        int decimal = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            decimal = binaryToDecimal(arr[i]);
            if (decimal % n == 0) {
                ++count;
            }
        }
        return count;
    }

    public static int binaryToDecimal(String inMsg) {
        int x = 0;
        for (char c : inMsg.toCharArray()) {
            x = x*2 + (c == '1' ? 1 : 0);
        }
        // System.out.println(inMsg + ": " + x);
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String biStr = sc.nextLine();
        sc.close();
        System.out.println(binaryDivisible(n, biStr));
    }
}