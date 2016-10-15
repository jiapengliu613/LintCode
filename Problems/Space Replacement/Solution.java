public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if (string == null || length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                count++;
            }
        }
        int slow = length - 1 + 2 * count, fast = length - 1;
        int result = slow + 1;
        while (fast >= 0) {
            if (string[fast] != ' ') {
                string[slow] = string[fast];
                fast--;
                slow--;
            } else {
                string[slow--] = '0';
                string[slow--] = '2';
                string[slow--] = '%';
                fast--;
            }
            
        }
        return result;
    }
}