// Naive Solution
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; -- i) {
            if (arr[i].trim().length() == 0) {
                continue;
            }
            str.append(arr[i]);
            str.append(" ");
        }
        return str.toString().trim();
    }
}
