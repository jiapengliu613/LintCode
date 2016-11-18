class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if (n < 0) {
            return 0;
        }
        int count = 0;
        if (k == 0) {
            count++;
        }
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while (cur > 0) {
                if (cur % 10 == k) {
                    count++;
                }
                cur = cur / 10;
            }
        }
        return count;
    }
};
