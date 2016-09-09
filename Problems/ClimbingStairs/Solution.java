public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        int[] f = new int[2];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i % 2] = f[(i - 1) % 2] + f[(i - 2) % 2];
        }
        return f[(n - 1) % 2];
    }
}