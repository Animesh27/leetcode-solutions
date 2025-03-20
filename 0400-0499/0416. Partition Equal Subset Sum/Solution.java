class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum %2 != 0){
            return false;
        }
        int n = nums.length;
        sum /= 2;
        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=sum;j++){
                if(j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}