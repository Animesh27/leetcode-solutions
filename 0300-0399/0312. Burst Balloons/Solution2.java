class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        int[][] dp = new int[n+2][n+2];
        return burst(dp, arr, 0, n+1);
    }

    public int burst(int[][] dp, int[] nums, int left, int right){
        if(left + 1 == right){
            return 0;
        }
        if(dp[left][right] > 0){
            return dp[left][right];
        }
        int maxCoins = 0;
        for(int i = left+1;i<right;i++){
            maxCoins = Math.max(maxCoins, nums[i]* nums[left]*nums[right]
                    + burst(dp, nums, left, i)
                    + burst(dp, nums, i, right));
        }
        dp[left][right] = maxCoins;
        return dp[left][right];
    }
}