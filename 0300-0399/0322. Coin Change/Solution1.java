class Solution {
    public int coinChange(int[] coins, int amount) {
        int val = helper(coins, amount);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    public int helper(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length;i++){
            if(amount >= coins[i]){
                int res = helper(coins, amount- coins[i]);
                if(res != Integer.MAX_VALUE && res+1 < min){
                    min = res +1;
                }
            }
        }
        return min;
    }
}