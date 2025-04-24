class Solution {
    int[] dr = {0, 1, -1, 0};
    int[] dc = {1, 0, 0, -1};
    public boolean isSafe(int r, int c, int R, int C){
        return r >= 0 && r < R && c>=0 && c < C;
    }
    public int maximumMinimumPath(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                min = Math.min(min, grid[i][j]);
            }
        }
        int low = min, high = grid[0][0], ans=0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(grid, mid)){
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean feasible(int[][] grid, int minScore){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int i = 0;i<4;i++){
                int r = node[0] + dr[i];
                int c = node[1] + dc[i];
                if(isSafe(r,c, m, n) && grid[r][c] >= minScore && !visited[r][c]){
                    q.add(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
        return visited[m-1][n-1];
    }
}