public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int start = 0, end = heights.length - 1;
        int result = 0;
        int leftMax = heights[0], rightMax = heights[heights.length - 1];
        while (start < end) {
            if (heights[start] < heights[end]) {
                start++;
                if (leftMax > heights[start]) {
                    result += leftMax - heights[start];
                } else {
                    leftMax = heights[start];
                }
            } else {
                end--;
                if (rightMax > heights[end]) {
                    result += rightMax - heights[end];
                } else {
                    rightMax = heights[end];
                }
            }
        }
        return result;
    }
}