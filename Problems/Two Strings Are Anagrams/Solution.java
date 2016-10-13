public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == t) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i : s.toCharArray()) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (char i : t.toCharArray()) {
            if (!map.containsKey(i) || map.get(i) <= 0) {
                return false;
            } else {
                map.put(i, map.get(i) - 1);
            }
        }
        return true;
    }
};