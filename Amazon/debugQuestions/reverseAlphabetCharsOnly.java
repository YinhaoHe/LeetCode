Amazon OA : Reverse Alphabet Chars Only
The following function returns a string representing the reversed string in such a way that the position fo the special chars are not affected.
The following code compiles successfully but fails to return the desired result. Your task is to fix the code so that it passes all test cases.

Ans: else {
                char temp = inputChar[left];
                inputChar[left] = inputChar[right];
                inputChar[right] = temp;
                left++;
                right--;
            }

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public String reverseAlphabetCharsOnly(String inputString) {
        char[] inputChar = inputString.toCharArray();
        int right = inputString.length() - 1;
        int left = 0;
        while(left < right) {
            if(!Character.isAlphabetic(inputChar[left]))
                left++;
            else if(!Character.isAlphabetic(inputChar[right]))
                right--;
            else {
                char temp = inputChar[left];
                inputChar[left] = inputChar[right];
                inputChar[right] = temp;
                left++;
                right--;
            }
        }
        return new String(inputChar);
    }
}
