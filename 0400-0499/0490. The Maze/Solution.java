class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]){
                return true;
            }
            for(int i = 0;i<4;i++){
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0){
                    r += dr[i];
                    c += dc[i];
                }
                r -= dr[i];
                c -= dc[i];
                if(!visited[r][c]){
                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return false;
    }
}