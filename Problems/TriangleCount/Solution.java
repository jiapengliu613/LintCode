public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
     // Loop for one side, and use two pointers to search for the other two sides
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int start, end;
        int count = 0;
        for (int i = 0; i < S.length; i++) {
            start = 0;
            end = i - 1;
            while (start < end) {
                if (S[start] + S[end] > S[i]) {
                    count += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }
        
        return count;
    }
}
