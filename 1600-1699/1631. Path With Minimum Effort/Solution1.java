class Solution {
    int[] dr = {0, 1, -1, 0};
    int[] dc = {1, 0, 0, -1};
    public boolean isSafe(int r, int c, int R, int C){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        pq.add(new int[]{0, 0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int val = cur[0], r = cur[1], c = cur[2];

            visited[r][c] = true;
            if(r == m-1 && c == n-1) return val;
            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(isSafe(nr, nc, m, n) && !visited[nr][nc]){
                    pq.add(new int[]{Math.max(val, Math.abs(heights[nr][nc] - heights[r][c])), nr, nc});
                }
            }
        }
        return -1;
    }
}