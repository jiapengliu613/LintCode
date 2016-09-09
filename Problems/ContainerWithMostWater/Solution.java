public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 2) {
            return 0;
        }
        int start = 0, end = heights.length - 1;
        int result = 0;
        while (start < end) {
            if (heights[start] < heights[end]) {
                result = Math.max(result, (end - start) * heights[start]);
                start++;
            } else {
                result = Math.max(result, (end - start) * heights[end]);
                end--;
            }
        }
        return result;
    }
}