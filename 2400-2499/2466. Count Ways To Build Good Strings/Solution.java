class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        dp[0] = 1;
        int MOD = 1_000_000_007;
        int sum = 0;
        for(int i = 1;i<=high;i++){
            if(i >= zero){
                dp[i] += dp[i - zero];
            }
            if(i >= one){
                dp[i] += dp[i - one];
            }
            dp[i] %= MOD;
            if(i >= low){
                sum += dp[i];
                sum %= MOD;
            }
        }
        return sum;
    }
}