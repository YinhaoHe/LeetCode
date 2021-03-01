import java.util.*;
import java.lang.*;
import java.io.*;

class Rotation {

	int countRotationUtil(int list[], int low, int high) {
		// corn case
		if (low > high) 
			return 0;
		if (low == high) 
			return low;

		int mid = low + (high - low) / 2;

		if (mid < high && list[mid + 1] < list[mid])
			return (mid + 1);
		if (mid > low && list[mid - 1] > list[mid])
			return mid;

		if (list[high] > list[mid])
			return countRotationUtil(list, low, mid);
		
		return countRotationUtil(list, mid, high);

	}

	int countRotations(int size, int list[]) {
		int res = countRotationUtil(list, 0, size - 1);
		return res;
	}

	public static void main (String args[]) {
		int[] list = {3, 4, 5, 6, 7, 1, 2};
		//int[] list = {5, 4, 3, 2, 1, 7, 6};
		//int[] list = {4, 1, 2, 3};
		Rotation ans = new Rotation();
		System.out.println(ans.countRotations(7, list));
	}
}