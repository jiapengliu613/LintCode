public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        String cur = new String();
        helper(n, 0, 0, result, cur);
        return result;
    }
    private void helper(int n, int l, int r, ArrayList<String> result, String s) {
        if (l == n && r == n) {
            result.add(s);
            return;
        }
        if (l >= r && l < n) {
            s += '(';
            helper(n, l + 1, r, result, s);
            s = s.substring(0, s.length() - 1);
        }
        if (r < l) {
            s += ')';
            helper(n, l, r + 1, result, s);
            s = s.substring(0, s.length() - 1);
        }
    }
    
}