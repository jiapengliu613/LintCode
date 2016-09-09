public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
     /*
     Use set to record wheather a char is repeated, the outer loop repeats once and the inner loop repeats once, so big O is O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int j = 0;
        int count = 0;
        int result = 0;
        String substr = new String();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            while (j < n) {
                if (!hashSet.contains(s.charAt(j))) {
                    hashSet.add(s.charAt(j));
                    count++;
                    j++;
                    
                } else {
                    break;
                }
            }
            result = Math.max(result, count);
            hashSet.remove(s.charAt(i));
            count--;
        }
        return result;
    }
}
