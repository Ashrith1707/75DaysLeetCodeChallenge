class Solution {

    static int fibb(int n, int dp[]) {
        // Base case
        if (n <= 2) {
            return n;
        }

        // If already computed → reuse
        if (dp[n] != -1) {
            return dp[n];
        }

        // Compute + store (memoization step)
        dp[n] = fibb(n - 1, dp) + fibb(n - 2, dp);

        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];   // size must be n+1
        Arrays.fill(dp, -1);

        return fibb(n, dp);
}
}