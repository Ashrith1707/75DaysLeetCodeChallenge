class Solution {

    // For each type, list of allowed directions (dr, dc)
    private static final int[][][] DIRS = {
        {},                         // 0 (unused)
        {{0,-1},{0,1}},             // 1: L, R
        {{-1,0},{1,0}},             // 2: U, D
        {{0,-1},{1,0}},             // 3: L, D
        {{0,1},{1,0}},              // 4: R, D
        {{0,-1},{-1,0}},            // 5: L, U
        {{0,1},{-1,0}}              // 6: R, U
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == m - 1 && c == n - 1) return true;

            int type = grid[r][c];

            // Try all directions allowed by current cell
            for (int[] d : DIRS[type]) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (vis[nr][nc]) continue;

                // Check reverse compatibility
                if (canComeBack(grid[nr][nc], -d[0], -d[1])) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }

    // Check if next cell supports reverse direction
    private boolean canComeBack(int type, int dr, int dc) {
        for (int[] d : DIRS[type]) {
            if (d[0] == dr && d[1] == dc) return true;
        }
        return false;
    }
}