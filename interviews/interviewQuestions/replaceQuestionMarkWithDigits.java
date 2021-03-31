import java.util.*;

class Solution {

	public String solution(String S) {

		if (S == null || S.length() == 0) return "";

		char[] digits = {'1', '2', '3'};
		char[] s = S.toCharArray(); 

		int len = S.length();
		char left = ' ';
		char right = ' ';

		for (int i = 0; i < len; i ++) {
			if (Character.isDigit(s[i])) continue;
			if (i > 0) left = s[i - 1];
			if (i < len - 1) right = s[i + 1];

			for (char digit : digits) {
				if (digit != left && digit != right) {
					s[i] = digit;
					break;
				}
			}
		}
		return new String(s);
	}

	public static void main(String args[]) {
		String test = "?1???2???3???1?";
		Solution sol = new Solution();
		
		System.out.println(sol.solution(test));
	}
}