class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        // O(nlog(n)) solution
        /*
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while (cur % 5 == 0) {
                count++;
                cur = cur / 5;
            }
        }
        return count;
        */
        long count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
};
