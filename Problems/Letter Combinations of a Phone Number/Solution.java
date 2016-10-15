public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    String[] s = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(digits, result, sb, 0);
        return result;
    }
    private void helper(String digits, ArrayList<String> result, StringBuilder sb, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '0';
        for (int j = 0; j < s[num - 2].length(); j++) {
            sb.append(s[num - 2].charAt(j));
            helper(digits, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    
    }
}