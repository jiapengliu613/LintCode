public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        String newS = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int length = 0;
        int index = newS.length() - 1;
        while (index >= 0 && newS.charAt(index) != ' ') {
            index--;
            length++;
        }
        return length;
    }
}