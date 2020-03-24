class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.isEmpty()) return true;
        if (s.length() % 2 != 0) return false;
        if (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == '[' || s.charAt(s.length() - 1) == '{' ) return false;
        for(int i = 0; i < s.length(); i ++) { 
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.isEmpty()) return false;
            else if (c == ')') {
                if(stack.pop() == '(') continue;
                else return false;
            }
            else if (c == ']') {
                if(stack.pop() == '[') continue;
                else return false;
            }
            else if (c == '}') {
                if(stack.pop() == '{') continue;
                else return false;
            }
        }
        return true;
    }
}