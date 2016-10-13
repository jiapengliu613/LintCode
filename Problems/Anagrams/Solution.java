public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }
        int n = strs.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            result.add(strs[i]);
            visited[i] = true;
            int size = result.size();
            for (int j = i + 1; j < n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (isAnagram(strs[i], strs[j])) {
                    result.add(strs[j]);
                    visited[j] = true;
                }
            }
            if (size == result.size()) {
                result.remove(size - 1);
                visited[i] = false;
            }
        }
        return result;
    }
    private boolean isAnagram(String s, String t) {
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
}