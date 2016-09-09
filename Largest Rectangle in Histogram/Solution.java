public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
     // Idea : for each element in the array, while it is larger than the peak of the stack, keep popping the stack. so it is guaranteed 
     //that each element in the stack is larger than the element below it. BigO is O(n) because each element is pushed and popped once.
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
