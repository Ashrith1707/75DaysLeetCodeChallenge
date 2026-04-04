import java.util.*;

class Solution {

    static void gp(int ind, int n, List<String> l, int open, int close, String curr) {
        if (ind == 2 * n) {
            l.add(curr);
            return;
        }

        if (open < n) {
            gp(ind + 1, n, l, open + 1, close, curr + "(");
        }

        if (close < open) {
            gp(ind + 1, n, l, open, close + 1, curr + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        gp(0, n, l, 0, 0, "");
        return l;
    }
}