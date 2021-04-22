class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        int counter = 0;
        
        for (int i = 0; i < J.length(); i ++) {
            set.add(J.charAt(i));
        }
        
        for (int j = 0; j < S.length(); j ++) {
            if(set.contains(S.charAt(j)))
                counter ++;
        }
        return counter;
    }
}