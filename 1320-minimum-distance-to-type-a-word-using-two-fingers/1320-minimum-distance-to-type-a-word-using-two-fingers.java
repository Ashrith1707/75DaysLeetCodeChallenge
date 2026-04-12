import java.util.*;

class Solution {

    // Manhattan distance between two letters (0–25)
    private int dist(int a, int b) {
        if (a == -1) return 0; // free initial position
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();

        // dp[j] = min cost where:
        // one finger is at previous char,
        // other finger is at position j
        int[] dp = new int[26];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Initially, cost = 0 (both fingers free)
        Arrays.fill(dp, 0);

        int prev = word.charAt(0) - 'A';

        for (int i = 0; i < n; i++) {
            int curr = word.charAt(i) - 'A';

            int[] next = new int[26];
            Arrays.fill(next, Integer.MAX_VALUE);

            for (int j = 0; j < 26; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;

                // Case 1: same finger moves (prev → curr)
                next[j] = Math.min(
                    next[j],
                    dp[j] + dist(prev, curr)
                );

                // Case 2: other finger moves (j → curr)
                next[prev] = Math.min(
                    next[prev],
                    dp[j] + dist(j, curr)
                );
            }

            dp = next;
            prev = curr;
        }

        int res = Integer.MAX_VALUE;
        for (int val : dp) {
            res = Math.min(res, val);
        }

        return res;
    }
}