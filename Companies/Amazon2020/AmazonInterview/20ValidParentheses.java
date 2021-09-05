public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        // corner case
        //if (s.length() == 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++ i) {
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.isEmpty()) return false;
                if (s.charAt(i) == ')' && stack.peek() != '(') return false;
                if (s.charAt(i) == ']' && stack.peek() != '[') return false;
                if (s.charAt(i) == '}' && stack.peek() != '{') return false;
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}