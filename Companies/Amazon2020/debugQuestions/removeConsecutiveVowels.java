Amazon OA : Remove Consecutive Vowels
The following function returns a string value representing the string left after removing consecutive vowels from the string.
The following code compiles successfully but fails to return the desired result. Your task is to fix the code so that it passes all test cases.

Ans: if((!is_vowel(str.charAt(i - 1))) || (!is_vowel(str.charAt(i))))

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    boolean is_vowel(char ch) {
        return (ch == 'a') || (ch == 'e') ||
                (ch == 'i') || (ch == 'o') ||
                (ch == 'u');
    }

    public String removeConsecutiveVowels(String str) {
        String str1 = "";
        str1 = str1+str.charAt(0);
        for(int i = 1; i < str.length(); i++)
            if((!is_vowel(str.charAt(i - 1))) ||
                    (!is_vowel(str.charAt(i)))) {
                char ch = str.charAt(i);
                str1 = str1 + ch;
            }
        return str1;
    }

}