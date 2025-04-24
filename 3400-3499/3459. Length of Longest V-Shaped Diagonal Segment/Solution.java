class Solution {
    public static int n;
    public static int m;
    public static Integer[][][][][] dp;
    public static int[] x = {1, 1, -1, -1};
    public static int[] y = {1, -1, -1, 1};
    public int lenOfVDiagonal(int[][] g) {
        n = g.length;
        m = g[0].length;
        dp = new Integer[n][m][2][3][4];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        ans = Math.max(ans, 1 + solve(i + x[k], j + y[k], 0, 2, k, g));
                    }
                }
            }
        }
        return ans;
    }
    public static int solve(int i, int j, int turn, int curr, int dir, int[][] g) {
        if (i >= n || i < 0 || j >= m || j < 0 || g[i][j] != curr) return 0;
        if (dp[i][j][turn][curr][dir] != null) return dp[i][j][turn][curr][dir];
        int ans = 1 + solve(i + x[dir], j + y[dir], turn, 2 - curr, dir, g);
        if (turn == 0) {
            ans = Math.max(ans, 1 + solve(i + x[(dir + 1) % 4], j + y[(dir + 1) % 4], 1, 2 - curr, (dir + 1) % 4, g));
        }
        return dp[i][j][turn][curr][dir] = ans;
    }
}