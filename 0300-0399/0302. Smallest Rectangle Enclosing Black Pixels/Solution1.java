class Solution {
    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, -1, 1, 0};
    int minRow = Integer.MAX_VALUE;
    int maxRow = Integer.MIN_VALUE;
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    public boolean isSafe(int r, int c, int R, int C){
        return r >= 0 && r < R && c >= 0 && c < C;
    }
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        dfs(image, x, y);
        if(minRow == Integer.MAX_VALUE){
            return 0;
        }
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        return height * width;
    }

    public void dfs(char[][] image, int x, int y){
        minRow = Math.min(minRow, x);
        maxRow = Math.max(maxRow, x);
        minCol = Math.min(minCol, y);
        maxCol = Math.max(maxCol, y);
        for(int i = 0;i<4;i++){
            int r = x + dr[i];
            int c = y + dc[i];
            if(isSafe(r, c, image.length, image[0].length) && image[r][c] == '1'){
                image[x][y] = '0';
                dfs(image, r, c);
            }
        }
    }
}