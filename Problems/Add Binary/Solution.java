public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        String result = "";
        int m = a.length(), n = b.length();
        int flag = 0;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            int sum = flag + a.charAt(i) - '0' + b.charAt(j) - '0';
            flag = sum >= 2 ? 1 : 0;
            result = String.valueOf(sum % 2) + result;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = flag + a.charAt(i) - '0';
            flag = sum >= 2 ? 1 : 0;
            result = String.valueOf(sum % 2) + result;
            i--;
        }
        while (j >= 0) {
            int sum = flag + b.charAt(j) - '0';
            flag = sum >= 2 ? 1 : 0;
            result = String.valueOf(sum % 2) + result;
            j--;
        }
        if (flag == 1) {
            result = '1' + result;
        }
        return result;
    }
}public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        String result = "";
        int m = a.length(), n = b.length();
        int flag = 0;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            int sum = flag + a.charAt(i) - '0' + b.charAt(j) - '0';
            flag = sum >= 2 ? 1 : 0;
            result = String.valueOf(sum % 2) + result;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = flag + a.charAt(i) - '0';
            flag = sum >= 2 ? 1 : 0;
            result = String.valueOf(sum % 2) + result;
            i--;
        }
        while (j >= 0) {
            int sum = flag + b.charAt(j) - '0';
            flag = sum >= 2 ? 1 : 0;
            result = String.valueOf(sum % 2) + result;
            j--;
        }
        if (flag == 1) {
            result = '1' + result;
        }
        return result;
    }
}