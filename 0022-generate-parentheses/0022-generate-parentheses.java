import java.util.*;

class Solution {

    static void gp(int idx, List<String> l, StringBuilder s, int i, int j, int n) {

        // base case
        if (idx == 2 * n) {
            l.add(s.toString());
            return;
        }

        // add '('
        if (i < n) {
            s.append('(');
            gp(idx + 1, l, s, i + 1, j, n);
            s.deleteCharAt(s.length() - 1); // backtrack
        }

        // add ')'
        if (j < i) {
            s.append(')');
            gp(idx + 1, l, s, i, j + 1, n);
            s.deleteCharAt(s.length() - 1); // backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        gp(0, l, new StringBuilder(), 0, 0, n);
        return l;
    }
}