public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return new String();
        }
        int n = s.length();
        boolean[][] isPalin = getPalin(s);
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPalin[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
    boolean[][] getPalin(String s) {
        int n = s.length();
        boolean[][] result = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 >= i - 1 || result[j + 1][i - 1]) {
                        result[j][i] = true;
                    } 
                }
            }
        }
        return result;
    }
}