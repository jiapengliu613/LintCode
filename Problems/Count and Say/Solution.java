public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String result = "1";
        
        for (int k = 2; k <= n; k++) {
            StringBuilder sb = new StringBuilder();
            char[] array = result.toCharArray();
            
            for (int i = 0; i < array.length; i++) {
                int count = 1;
                while (i + 1 < array.length && array[i] == array[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(array[i]));
            }
            result = sb.toString();
            
        }
        return result;
    }
}