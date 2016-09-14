public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        
        int n = s1.length();
        int[][][] visited = new int[n][n][n + 1];
        boolean result = helper(s1, 0, s2, 0, n, visited);
        
        return result;
    }
    boolean helper(String s1, int start1, String s2, int start2, int len, int[][][] visited) {
        if (visited[start1][start2][len] == 1) {
            return true;
        }
        if (visited[start1][start2][len] == -1) {
            return false;
        }
        if (s1.length() == 0 || s1.equals(s2)) {
            visited[start1][start2][len] = 1;
            return true;
        }
        if (!isValid(s1, s2)) {
            visited[start1][start2][len] = -1;
            return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            String s23 = s2.substring(s2.length() - i);
            String s24 = s2.substring(0, s2.length() - i);
            if (helper(s11, start1, s21, start2, i, visited) && helper(s12, start1 + i, s22, start2 + i, len - i, visited)) {
                visited[start1][start2][len] = 1;
                return true;
            }
            if (helper(s11, start1, s23, start2 + len - i, i, visited) && helper(s12, start1 + i, s24, start2, len - i, visited)) {
                visited[start1][start2][len] = 1;
                return true;
            }
        }
        visited[start1][start2][len] = -1;
        return false;
    }
    private boolean isValid(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!(new String(arr1)).equals(new String(arr2))) {
            return false;
        }
        return true;
    }
}