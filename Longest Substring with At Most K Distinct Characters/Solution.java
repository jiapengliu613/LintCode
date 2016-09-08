public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
     /* This solution needs to update result in while loop, which can be modified by modifying the judgement condition */ 
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        int j = 0;
        int result = 0;
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (isValid(k, hash)) {
                    hash[s.charAt(j)]++;
                    result = Math.max(result, j - i);
                    j++;
                    
                } else {
                    break;
                }
            }
            if (isValid(k, hash)) {
                if (result < j - i) {
                    result = j - i;
                }
            }
        
            hash[s.charAt(i)]--;
            //System.out.print(result);
        }
        return result;
    }
    boolean isValid(int k, int[] hash) {
        int count = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                count++;
            }
        }
        return count <= k;
    }
}
