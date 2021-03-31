/*
给定一个字符串数组 五个名字 找出这五个名字中哪个名字的字母最多 不包含重复和空格
*/

import java.util.Scanner;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		String[] names = new String[5];
		int index = 0;
		while (input.hasNextLine()) {
			names[index++] = input.nextLine();
		}

		String leader = findNameWithMaxLetters(names);
		System.out.println(leader);
	}

	private static String findNameWithMaxLetters(String[] names) {
		Map<String, Integer> nameLetter = new HashMap<>();

		for (String name : names) {
			int numberOfLetters = countNumberOfLetters(name.toLowerCase());
			nameLetter.put(name, numberOfLetters);
		}

		Arrays.sort(names, (s1, s2) -> {
			return nameLetter.get(s1) == nameLetter.get(s2) ? s1.compareTo(s2) : nameLetter.get(s2) - nameLetter.get(s1);
		});

		return names[0];
	}

	private static int countNumberOfLetters(String name) {
		int[] counts = new int[26];
		int letterCount = 0;

		for (int i = 0; i < name.length(); ++ i) {
			char letter = name.charAt(i);

			if (!Character.isLetter(letter)) continue;

			if (counts[letter - 'a'] == 1) continue;

			counts[letter - 'a'] ++;
			letterCount ++;
		}
		return letterCount;
	}
}