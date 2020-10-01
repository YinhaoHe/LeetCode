/*

unique characters
check if string only contains unique characters

*/
import java.util.*;

class uniqueCharacters{
	public static boolean isUnique(String string) {

		// 1. str -> char array

		char[] strArray = string.toCharArray();

		// 2. use hashset to determine if unique

		HashSet<Character> hs = new HashSet<Character>();

		for (char str : strArray) {
			if (!hs.contains(str)) {
				hs.add(str);
			} else {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {

		// test case
		String t1 = "abcd";
		String t2 = "asasasfgg";
		String t3 = "qwerty";

		System.out.println(isUnique(t1));
		System.out.println(isUnique(t2));
		System.out.println(isUnique(t3));
	}
}