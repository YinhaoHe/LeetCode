/*
Amazon OA : Check Pair Sum Exists

The following function returns a boolean value representing if there is a pair with given sum exists in the array.
The following code compiles successfully but fails to return the desired result. Your task is to fix the code so that it passes all test cases.
*/

Ans: put temp = "0" into {}


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
            else
                sum += Integer.parseInt(temp);
            temp = "0";
        }
        return sum + Integer.parseInt(temp);
    }
}

