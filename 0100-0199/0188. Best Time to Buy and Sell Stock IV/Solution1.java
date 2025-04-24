class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            int price = prices[i - 1];
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + price); // sell or rest
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - price); // buy or rest
            }
        }
        return dp[n][k][0];
    }
}