Amazon OA : Calculate Sum Of Numbers In String
The following function returns a positive integer representing the sum of numbers in the inputString.
The following code compiles successfully but fails to return the desired result. Your task is to fix the code so that it passes all test cases.

Ans: else   {
                sum += Integer.parseInt(temp);
                temp = "0";
            }

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int calculateSumOfNumbersInString(String inputString) {
        String temp = "";
        int sum = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if(Character.isDigit(ch))
                temp += ch;
            else {
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }
}
