/*

Maximum occurring character

Return maximum occurring character in an input string.
Write an efficient function to return maximum occurring character in the input string 
e.g., if input string is “test” then function should return ‘t’.

*/

class solution {

	static int ASCII_SIZE = 256; // In total, there are 256 ASCII 
	char getMaxOccuringChar(String str) {
		int[] count = new int[ASCII_SIZE]; // Create a count array to store the result

		int len = str.length(); // str length
		for (int i = 0; i < len; i ++) {
			count[str.charAt(i)] ++; // traversal the str and plus one on the count array
		}

		// Next part is to find the max one
		int max = Integer.MAX_VALUE; // Initialize max
		char ans = ' '; // Initialize ans char

		// Find the max one
		for (int i = 0; i < len; i ++) {
			if (count[str.cahrAt(i)] > max) {
				max = count[str.charAt(i)]; // make sure the first one will be return when two equal values exist
				ans = str.charAt(i);
			}
		}

		return ans; 
	}
}