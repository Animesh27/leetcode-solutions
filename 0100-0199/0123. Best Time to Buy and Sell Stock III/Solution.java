class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][3][2];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 2; k++) {
                dp[i][k][1] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            int price = prices[i - 1];
            for (int k = 1; k <= 2; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + price); // sell or rest
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - price); // buy or rest
            }
        }
        return dp[n][2][0];
    }
}