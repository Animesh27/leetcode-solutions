class Solution {
    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, 1, -1, 0};
    public boolean isSafe(int r, int c, int R, int C){
        return r >= 0 && r < R && c >= 0 && c<C;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i, j, visited, grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, boolean[][] visited, char[][] grid){
        visited[i][j] = true;
        for(int k = 0;k<4;k++){
            int r = i + dr[k];
            int c = j + dc[k];
            if(isSafe(r, c, grid.length, grid[0].length) && grid[r][c] == '1' && !visited[r][c]){
                dfs(r, c, visited, grid);
            }
        }
    }
}