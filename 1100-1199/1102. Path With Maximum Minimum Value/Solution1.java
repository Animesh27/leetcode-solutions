class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Max-heap based on the value of the cell
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[]{grid[0][0], 0, 0}); // {minSoFar, row, col}
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0], r = cur[1], c = cur[2];

            // Reached destination
            if (r == m - 1 && c == n - 1) return val;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{
                            Math.min(val, grid[nr][nc]),
                            nr,
                            nc
                    });
                }
            }
        }
        return -1; // Should not reach here
    }
}
