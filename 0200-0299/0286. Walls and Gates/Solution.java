class Solution {
    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, -1, 1, 0};
    public boolean isSafe(int r, int c, int R, int C){
        return r >= 0 && r < R && c>=0 && c<C;
    }
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(rooms[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] point = q.poll();
            for(int i = 0;i<4;i++){
                int r = point[0] + dr[i];
                int c = point[1] + dc[i];
                if(isSafe(r, c, m, n) && rooms[r][c] == Integer.MAX_VALUE){
                    rooms[r][c] = rooms[point[0]][point[1]] + 1;
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}