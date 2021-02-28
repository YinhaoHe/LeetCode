Amazon OA : Compare Product
The following function returns a Boolean value "true" if the product of digits at the even and odd places of a number are equal.
The following code compiles successfully but fails to return the desired result. Your task is to fix the code so that it passes all test cases.

Ans: int digit = num % 10;
	 digit = num % 10;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public boolean compareProduct(int num) {
        if (num < 10)
            return false;
        int oddProdValue = 1, evenProdValue = 1;

        while(num > 0) {
            int digit = num % 10;
            oddProdValue *= digit;
            num = num / 10;
            if(num == 0)
                break;
            digit = num % 10;
            evenProdValue *= digit;
            num = num / 10;
        }
        if(evenProdValue == oddProdValue)
            return true;
        return false;
    }
}
