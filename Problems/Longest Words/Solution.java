class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> result = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) {
            return result;
        }
        int maxLength = 0;
        for (String s : dictionary) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        for (String s : dictionary) {
            if (s.length() == maxLength) {
                result.add(s);
            }
        }
        return result;
    }
};