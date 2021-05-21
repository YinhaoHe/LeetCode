class Solution {
    public String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);
            if (c == ' ') {
                str.append("%20");
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}