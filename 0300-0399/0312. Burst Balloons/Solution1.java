class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        int[][] dp = new int[n+2][n+2];
        for(int len = 2;len<=n+1;len++){
            for(int left = 0;left+len <=n+1;left++){
                int right = left + len;
                for(int i = left+1;i<right;i++){
                    dp[left][right] = Math.max(dp[left][right], arr[i]*arr[left]*arr[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n+1];
    }
}