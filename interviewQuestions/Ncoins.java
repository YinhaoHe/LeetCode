/*

翻转数列 将一个仅包含 0， 1的数列变成 010101 或 101010

**/

import java.util.*;

class Solution{

	public static void main(String args[]) {
		int[] A = {1, 0, 1, 0, 1, 1};
		System.out.println(minFlip(A));
	}

	public static int flip (int num) {
		return (num == 0 ? 1 : 0);
	}

	public static int getFlip(int A[], int target) {
		int flipCount = 0;
		for (int i = 0; i < A.length; i ++) {
			if (A[i] != target) {
				flipCount ++;
			}
			target = flip(target);
		}
		return flipCount;
	}

	public static int minFlip(int A[]) {
		return Math.min(getFlip(A, 0), getFlip(A, 1));
	}
}