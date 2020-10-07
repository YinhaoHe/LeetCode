# Interviews

## Interview process

### Culture interview

- Diverse
- Collaborative
- Team oriented

Offer example of being a team player

Just be yourself

[Back to top](#interviews)

---

### Systems interview

- Describe previous architectures
- Pain points
- Solutions
- Communication
- General system knowledge
- trouble shooting
- Problem solving
- reasoning

[Back to top](#interviews)

---

### Programming interview

- Show and tell - walk through code
- Programming challenge 
  - Solve the problem (psedo code, draw pictures, brutal force is OK)
  - What are you like to work with? (Innovation, be honest to speak I don't know, communication!)

[Back to top](#interviews)

---

### Tips

- Write tests - unit tests 
- Think out loud - share thinking process
- Share your assumptions - 可以先假设我有什么 然后再实现
- Ok to say I don't know
- Just try - all about attitude - "I don't know how to do this, Lets see how it goes."
- Attitude! Continously improving. 

[Back to top](#interviews)

---

## Commonly asked coding interview questions

### Unique Characters

check if a String only contains unique characters

- My solution:

```java
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
```

- OPT:

```java
package challenges.arraysAndStrings;

public class UniqueCharacterDetector {

    // There are lots of ways we could solve this:
    //  - HashMap where we store every character and a boolean on whether found
    //  - An array that counts the number of times a character occurs
    //
    // But as an example of of how optimized and tight we can make this, checkout this solution below
    // to see how a simple array, that stores booleans, gives us everything we need.

    public boolean isUnique(String text) {
        // Create an array representing all unique 128 characters in ASCII.
        // Set a flag to true for each letter.

        // Return false when we find we already have a match.

        // If length > 128 there must be a duplicate
        if (text.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < text.length(); i++) {
            int val = text.charAt(i); // char can be int
            if (char_set[val]) { // Already found
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }


}

```

[Back to top](#interviews)

---

### Permutation

Check is a String is a permutation of others.

e.g. "abc" is a permuation of "bac"

Not case sensitive

Same number of Character, different order

- My solution:

```java
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
```

- OPT:

```java
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
```

[Back to top](#interviews)

---

### URLify

Given a String, convert all spaces to '%20'

- My solution

```java
/*

Given a String, convert all space character to "%20" ASCII number

*/

import java.util.*;

class URLify {
	public String makeURL (String s) {
		String res = s.trim().replace(" ", "%20");
		return res;
	}

	public static void main(String[] args) {
		String s = "   I love you";
		URLify urlify = new URLify();
		System.out.println(urlify.makeURL(s));
	}
}

```

