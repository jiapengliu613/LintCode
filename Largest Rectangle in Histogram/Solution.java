public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i <= height.length; i++) {
            int curHeight = (i == height.length) ? - 1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= curHeight) {
                int h = height[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - (stack.peek() + 1);
                result = Math.max(result, h * w);
            }
            stack.push(i);
        }
        return result;
    }
}
