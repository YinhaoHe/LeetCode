/*

Maximum frequency substring

Given a string s, return the maximum number of ocurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.

*/

class solution {
	public int maxFrequ(String s, int maxLetters, int minSize, int maxSize) {
		int res = 0;
		int n = s.length();
		Map<String, Integer> map = new HashMap<>();
		int[] arr = new int[26];
		int count = 0;

		for (int i = 0; i < n - minSize + 1; i ++) {
			String sub = s.substring(i, i + minSize);
			if (i == 0) {
				for (char c : sub.toCharArray()) {
					arr[c - 'a'] ++;
					if (arr[c - 'a'] == 1) {
						count ++;
					}
				}
			} else {
				int left = s.charAt(i - 1) - 'a';
				int right = sub.charAt(minSize - 1) - 'a';
				arr[left] --;
				if (arr[left] == 0) count --;
				arr[right] ++;
				if (arr[right] == 1) count ++;
			}

			if (count > maxLetters) continue;
			map.put(sub, map.getOrDefault(sub, 0) + 1);
			res = Math.max(res, map.get(sub));
		}
		return res;
	}
}
