import java.util.*;

class Solution {

	public String solution(int N, int[] A) {
		if (N == 0) return "";
		char[] sAr = new char[N];
		Arrays.fill(sAr, '-');
		if (A.length != 0) {
			for (int i : A) {
				sAr[i] = '+';
			}
		}
		
		return new String(sAr);
	}

	public static void main(String args[]) {
		int N = 7;
		int[] A = {3, 6, 0, 3};
		Solution sol = new Solution();
		System.out.println(sol.solution(N, A));
	}
}