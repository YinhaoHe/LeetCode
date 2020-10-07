import java.util.*;

class Permutation_OPT {
	public static boolean isPermutation(String s1, String s2) {
		return sort(s1).equals(sort(s2));
	}

	private static String sort(String text) {
		char[] tArr = text.toCharArray();
		Arrays.sort(tArr);
		return new String(tArr);
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "bac";
		System.out.println(isPermutation(s1, s2));
	}
}