import java.util.Scanner;
import java.util.*;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int jarNum = sc.nextInt();
		int[] chocoArray = new int[jarNum];
		for (int i = 0; i < jarNum; i ++) {
			chocoArray[i] = sc.nextInt();
		}
		System.out.println(chocoMax(chocoArray));
	}

	public static int chocoMax(int[] chocoArray) {
		int n = chocoArray.length;
		if (n == 0) return n;
		if (n == 1) return chocoArray[0];
		if (n == 2) return Math.max(chocoArray[0], chocoArray[1]);

		int[] dp = new int[n];
		int maxChoco = Integer.MIN_VALUE;
		dp[0] = chocoArray[0];
		dp[1] = Math.max(chocoArray[0], chocoArray[1]);

		for (int i = 2; i < n; i ++) {
			dp[i] = Math.max((dp[i - 2] + chocoArray[i]), (dp[i - 1]));
			maxChoco = Math.max(dp[i], maxChoco);
		}
		return maxChoco;
	}
}