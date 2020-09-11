public static String maxSubstring(String s) {
    // Write your code here
        String maxString = "";
        for (int i = 0; i < s.length(); i ++) {
            if (maxString.compareTo(s.substring(i)) <= 0) {
                maxString = s.substring(i);
            }
        }
        return maxString;
    }
}