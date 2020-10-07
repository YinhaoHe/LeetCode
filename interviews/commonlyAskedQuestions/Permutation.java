/*

Check is a String is a permutation of others.

e.g. "abc" is a permuation of "bac"

Not case sensitive

Same number of Character, different order

*/

import java.util.*;

class Permutation{
	public static boolean isPermutation(String str1, String str2) {

		// 1. S1, S2 -> lowercase for not being case sensitive
		// 2. S1 store in a HashMap; S2 loop and compare
		String s1 = str1.toLowerCase();
		String s2 = str2.toLowerCase();

		if (s1.length() != s2.length())
			return false;

		int len = s1.length();

		HashMap<Character, Integer> map1 = new HashMap<>();
		for (int i = 0; i < len; i ++) {
			map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
		}

		HashMap<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < len; i ++) {
			map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
		}

		for (int j = 0; j < len; j ++) {
			if (map1.containsKey(s2.charAt(j))) {
				if (map1.get(s2.charAt(j)) == map2.get(s2.charAt(j))) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "bac";
		System.out.println(isPermutation(s1, s2));
	}
}