class Solution {
    public int romanToInt(String s) {
        
        //Map Roman with Integers
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        //res initiate first Roman
        int res = map.get(s.charAt(0));
        
        //if char[i]<char[i-1] then add it to res
        //if char[i]>char[i-1] then add char[i]-char[i-1] to res
        for(int i = 1; i < s.length(); i ++) {
            if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                res += (map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1))) ;
            }
            else {
                res += map.get(s.charAt(i));
            }
        }
        
        return res;
    }
}