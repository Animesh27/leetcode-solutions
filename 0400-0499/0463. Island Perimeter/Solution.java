class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    int p = 4;
                    if(i-1 >= 0 && grid[i-1][j] == 1){
                        p--;
                    }
                    if(i+1 < m && grid[i+1][j] == 1){
                        p--;
                    }
                    if(j-1 >= 0 && grid[i][j-1] == 1){
                        p--;
                    }
                    if(j+1 < n && grid[i][j+1] == 1){
                        p--;
                    }
                    ans += p;
                }
            }
        }
        return ans;
    }
}