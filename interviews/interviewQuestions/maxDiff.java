// Sample code to read input and write output:

/*		
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution 
{
	public static void main(String args[] )
	{
		// Use either of these methods for input

		//BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name1 = br.readLine();            // Read input from STDIN
		System.out.println("Hello " + name1);    // Write output to STDOUT

		//Scanner
		Scanner s = new Scanner(System.in);
		String name2 = s.nextLine();             // Read input from STDIN
		System.out.println("Hello " + name2);    // Write output to STDOUT
	}
}
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
class Solution 
{
	public static void maxDiff(int len, int[] nums) {
	    int max = 0;
	   // if (nums == null) {
	   //     return;
	   // }
	   // if (len < 2) {
	   //     max = 0;
	   // }
	    int rightMax = nums[len - 1];
	    for (int i = len - 2; i >= 0; i --) {
	        if (nums[i] > rightMax) {
	            rightMax = nums[i];
	        } else {
	           int tmp = rightMax - nums[i];
	           if (tmp > max) {
	               max = tmp;
	           }
	        }
	    }
	    System.out.println(max);
	}
	
	public static void main(String args[] )
	{
		// Write your code here
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] nums = new int[len];
		for (int i = 0; i < len; i ++) {
		    nums[i] = sc.nextInt();
		}
		maxDiff(len, nums);
	}
}