public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (ch == ')') {
                if (stack.peek() != '(')
                    return false;
                stack.pop();
            } else if (ch == ']') {
                if (stack.peek() != '[')
                    return false;
                stack.pop();
            } else if (ch == '}') {
                if (stack.peek() != '{') 
                    return false;
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}