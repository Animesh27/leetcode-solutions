class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n+1][3];
        for(int i = n-1;i>=0;i--){
            dp[i][0] = Math.min(dp[i+1][1], dp[i+1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i+1][0], dp[i+1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i+1][1], dp[i+1][0]) + costs[i][2];
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}