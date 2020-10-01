/*

Check is a String is a permutation of others.

e.g. "abc" is a permuation of "bac"

Not case sensitive

Same number of Character, different order

*/

import java.util.*;

class Permutation{
	public static boolean isPermutation(String s1, String s2) {

		// 1. S1, S2 -> lowercase for not being case sensitive
		// 2. S1 store in a HashMap; S2 loop and compare

		if (s1.length() != s2.length())
			return false;

		int len = s1.length();

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i ++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		}

		for (int j = 0; j < len; j ++) {
			map.containsKey()
		}

	}
}