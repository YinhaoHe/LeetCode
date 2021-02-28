Amazon OA : Count Triplet Sum Permutations
The following function countTripletSumPermutations returns an integer representing the number of triplets from the list whose product is equal to the given tripletSum.
The following code compiles successfully but fails to return the desired result. Your task is to fix the code so that it passes all test cases.

Ans: for(int j = i + 1; j < size - 1; j++)

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int countTripletSumPermutations(int size, int[] arr, int tripletSum)
    {
        int count = 0;
        for(int i = 0; i < size - 2; i++)
        {
            if(tripletSum % arr[i] == 0)
            {
                for(int j = i + 1; j < size - 1; j++)
                {
                    if(tripletSum % (arr[i] * arr[j]) == 0)
                    {
                        int value = tripletSum / (arr[i] * arr[j]);
                        for(int k = j + 1; k < size; k++)
                            if(arr[k] == value)
                                count++;
                    }
                }
            }

        }
        return count;
    }
}
