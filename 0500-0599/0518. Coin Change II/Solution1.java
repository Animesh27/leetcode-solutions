class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length][amount+1];
        return helper(coins, coins.length-1, amount, memo);
    }

    public int helper(int[] coins, int index, int amount, Integer[][] memo){
        if (amount == 0) return 1;
        if (index < 0 || amount < 0) return 0;
        if(memo[index][amount] != null) return memo[index][amount];
        int take = helper(coins, index, amount - coins[index], memo);
        int not_take = helper(coins, index-1, amount, memo);
        return memo[index][amount] = take + not_take;
    }
}