class Solution {
    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, -1, 1, 0};
    public boolean isSafe(int r, int c, int R, int C){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            while(size-- > 0){
                int[] val = q.poll();
                for(int i = 0;i<4;i++){
                    int r = val[0] + dr[i];
                    int c = val[1] + dc[i];
                    if(isSafe(r, c, m, n) && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        freshOranges--;
                        flag = true;
                    }
                }
            }
            if(flag)
                ans++;
        }
        return freshOranges == 0 ? ans: -1;
    }
}