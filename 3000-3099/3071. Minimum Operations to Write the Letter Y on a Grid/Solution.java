class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int center = n/2;
        int[] yFreq = new int[3];
        int[] nonYFreq = new int[3];
        int totalY = 0;
        int totalNonY = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isOnY(n, center, i, j)){
                    yFreq[grid[i][j]]++;
                    totalY++;
                } else {
                    nonYFreq[grid[i][j]]++;
                    totalNonY++;
                }
            }
        }

        int minOp = Integer.MAX_VALUE;
        for(int y = 0;y<3;y++){
            for(int nonY = 0;nonY < 3;nonY++){
                if(y == nonY){
                    continue;
                }
                int yCost = totalY - yFreq[y];
                int nonYCost = totalNonY - nonYFreq[nonY];
                minOp = Math.min(minOp, yCost + nonYCost);
            }
        }
        return minOp;
    }

    public boolean isOnY(int n, int center, int r, int c){
        return (r == c && r <= center) || ((r+c+1) == n && r<=center) || (r > center && c == center);
    }
}