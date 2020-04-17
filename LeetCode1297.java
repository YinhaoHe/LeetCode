class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] letterCount = new int[26];  /*count letter*/ 
        char[] strs = s.toCharArray();
        Map<String,Integer> stringCount = new HashMap<>();  /*count specific string satisfy requirement.*/
        int start = 0, end = start + minSize - 1, letterTotal = 0, ans = 0; /*letterTotal stores current total number of distinct letter. */
		/*deal with the first string with minSize. */
        for(int i = start; i <= end; i++){
            if(letterCount[strs[i] - 'a'] == 0) letterTotal++;
            letterCount[strs[i] - 'a']++;
        }
        if(letterTotal <= maxLetters){
            stringCount.put(s.substring(start, end + 1), 1);
            ans = 1;
        }
		
		/*slide in one letter, slide out one letter, and check if the substring in the sliding window satisfy the requirement. */
		
        end++;
        while(end < s.length()){
            if(letterCount[strs[end] - 'a']++ == 0) letterTotal++;
            if(letterCount[strs[start] - 'a']-- == 1) letterTotal--;
            start++;
            if(letterTotal <= maxLetters){
                String curStr = s.substring(start, end + 1);
                stringCount.put(curStr, stringCount.getOrDefault(curStr, 0) + 1);
                ans = Math.max(ans, stringCount.get(curStr));
            }
            end++;
        }
        return ans;
    }
}