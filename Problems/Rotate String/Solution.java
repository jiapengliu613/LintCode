public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0 || offset % str.length == 0) {
            return;
        }
        int n = str.length;
        rotate(str, 0, n - 1);
        rotate(str, 0, offset % n - 1);
        rotate(str, offset % n, n - 1);
        return ;
    }
    private void rotate(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }
}