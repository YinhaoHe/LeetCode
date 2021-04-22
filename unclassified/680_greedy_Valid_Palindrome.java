import java.util.*;

class Solution {

	public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;

        while (low < high) {
        	if (s.charAt(low) == s.charAt(high)) {
        		low ++;
        		high --;
        	} else {
        		return (isPalindrome(s, low + 1, high) || isPalindrome(s, low, high - 1));
        	}
        }
        return true;
    }

	// helper 
	public boolean isPalindrome(String str, int low, int high) {
		while (low < high) {
			if (str.charAt(low) != str.charAt(high)) {
				return false;
			}
			low ++;
			high --;
		}
		return true;
	}

	public static void main(String args[]) {
		Solution test = new Solution();
		String tmp = "aba";
		System.out.println(test.validPalindrome(tmp));
	}
}