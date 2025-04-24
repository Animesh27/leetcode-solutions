class Solution {
    final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean isSafe(int r, int c, int n){
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.size();
        int[][] mat = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid.get(i).get(j) == 1){
                    q.add(new int[]{i,j});
                    mat[i][j] = 0;
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                for(int[] d: dir){
                    int di = curr[0] + d[0];
                    int dj = curr[1] + d[1];
                    int val = mat[curr[0]][curr[1]];
                    if(isSafe(di, dj, n) && mat[di][dj] == -1){
                        mat[di][dj] = val+1;
                        q.add(new int[]{di, dj});
                    }
                }
            }
        }
        int low = 0, ans = -1;
        int high = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                high = Math.max(high, mat[i][j]);
            }
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(mat, mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean feasible(int[][] grid, int minSafeness){
        int n = grid.length;
        if(grid[0][0] < minSafeness || grid[n-1][n-1] < minSafeness) return false;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == n-1 && curr[1] == n-1){
                return true;
            }
            for(int[] d: dir){
                int di = curr[0] + d[0];
                int dj = curr[1] + d[1];
                if(isSafe(di, dj, n) && !visited[di][dj] && grid[di][dj] >= minSafeness){
                    visited[di][dj] = true;
                    q.add(new int[]{di, dj});
                }
            }
        }
        return false;
    }
}