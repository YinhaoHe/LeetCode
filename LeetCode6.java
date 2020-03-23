class Solution {
    public String convert(String s, int numRows) {
        //edge case such as numRows equal 1
        if (numRows == 1) return s;
        //Define a new String to store the result
        StringBuilder res = new StringBuilder();
        
        int size = 2 * numRows - 2; // one cycle size
        int n = s.length(); // define String s length
        
        //循环行数
        for (int i = 0; i < numRows; i ++) {
            //循环size
            for (int j = 0; j + i < n; j += size) {
                res.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + size - 1 < n) {
                    res.append(s.charAt(j + size - i));
                }
            }
        }
        return res.toString();
    }
}