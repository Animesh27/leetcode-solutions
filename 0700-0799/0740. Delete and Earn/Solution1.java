class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxNumber = 0;
        for(int num: nums){
            counts.put(num, counts.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        int[] dp = new int[maxNumber+1];
        dp[1] = counts.getOrDefault(1, 0);

        for(int i = 2;i<dp.length;i++){

            dp[i] = counts.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
        }
        return dp[maxNumber];
    }
}