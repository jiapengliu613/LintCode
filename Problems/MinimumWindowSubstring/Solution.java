public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
     /*Use hashmap to record the frequency of a char appears, TLE in leetcode which is because of the use of count and substr .etc*/
     
    public String minWindow(String source, String target) {
        // write your code
        if (source == null || target == null || source.length() < target.length()) {
            return "";
        }
        int j = 0;
        int count = 0, result = Integer.MAX_VALUE;
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : target.toCharArray()) {
            if (!targetMap.containsKey(c)) {
                targetMap.put(c, 1);
            } else {
                targetMap.put(c, targetMap.get(c) + 1);
            }
        }
        String substr = "";
        String resultStr = "";
        HashMap<Character, Integer> sourceMap = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length()) {
                if (!isLarger(sourceMap, targetMap)) {
                    substr += source.charAt(j);
                    if (!sourceMap.containsKey(source.charAt(j))) {
                        sourceMap.put(source.charAt(j), 1);
                    } else {
                        sourceMap.put(source.charAt(j), sourceMap.get(source.charAt(j)) + 1);
                    }
                    count++;
                    j++;
                } else {
                    break;
                }
            }
            if (isLarger(sourceMap, targetMap)) {
                if (result > count) {
                    result = count;
                    resultStr = substr;
                }
            }
            count--;
            substr = substr.substring(1,substr.length());
            if (sourceMap.containsKey(source.charAt(i)) && sourceMap.get(source.charAt(i)) != 1) {
                sourceMap.put(source.charAt(i), sourceMap.get(source.charAt(i)) - 1);
            } else {
                sourceMap.remove(source.charAt(i));
            }
            
        }
        if (result != Integer.MAX_VALUE) {
            return resultStr;
        } else {
            return "";
        }
    }
    public boolean isLarger(HashMap<Character, Integer> source, HashMap<Character, Integer> target) {
        for (Map.Entry entry : target.entrySet()) {
            if (!source.containsKey(entry.getKey()) || source.get(entry.getKey()) < (Integer)entry.getValue()) {
                return false;
            } 
        }
        return true;
    }
}
/*Array version*/
public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if (source == null || target == null || source.length() < target.length()) {
            return "";
        }
        int[] sourceMap = new int[256];
        int[] targetMap = new int[256];
        for (char c : target.toCharArray()) {
            targetMap[c]++;
        }
        int j = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length()) {
                if (!isLarger(sourceMap, targetMap)) {
                    sourceMap[source.charAt(j)]++;
                    j++;
                } else {
                    break;
                }
            }
            if (isLarger(sourceMap, targetMap)) {
                if (min > j - i) {
                    min = j - i;
                    result = source.substring(i,j);
                }
            }
                
            sourceMap[source.charAt(i)]--;
        }
        if (min != Integer.MAX_VALUE) {
            return result;
        }
        return "";
    }
    public boolean isLarger(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] < target[i]) {
                return false;
            }
            
        }
        return true;
    }
}
