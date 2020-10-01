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

