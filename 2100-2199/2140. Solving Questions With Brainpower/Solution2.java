class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        long max = dp[n-1];
        for(int i = n-2;i>=0;i--){
            int index = questions[i][1] + i + 1;
            dp[i] = Math.max(dp[i+1], questions[i][0] + (index < n ? dp[index] : 0));
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}