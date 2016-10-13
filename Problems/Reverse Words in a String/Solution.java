public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if (s.length() == 0) {
            return s;
        }
        int n = s.length();
        // first reversal
        int start = 0, end = n - 1;
        while (start < n && s.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (start >= n) {
            return new String();
        }
        char[] array = s.substring(start, end + 1).toCharArray();
        start = 0;
        end = array.length - 1;
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        //System.out.println();
        // second reversal
        int slow = 0, fast = 0;
        //System.out.println(slow);
        while (fast < array.length) {
            while (fast < array.length && array[fast] != ' ') {
                fast++;
            }
            //System.out.println(fast);
            int tail = fast - 1;
            while (slow < tail) {
                char temp = array[slow];
                array[slow] = array[tail];
                array[tail] = temp;
                slow++;
                tail--;
            }
            slow = fast;
            slow++;
            fast++;
        }

        return new String(array);
        
    }
}

//
public class Solution {
 /**
 * @param s : A string
 * @return : A string
 */
 public String reverseWords(String s) {
 // write your code
    if (s.length() == 0) {
        return s;
    }
    String[] array = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = array.length - 1; i>= 0; i--) {
        if (array[i] != " ") {
            sb.append(array[i]).append(" ");
        }
    }
    return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
 }
}
