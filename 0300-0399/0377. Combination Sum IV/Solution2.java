class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target+1];
        return helper(nums, target, memo);
    }

    public int helper(int[] nums, int target, Integer[] memo){
        if(target < 0) return 0;
        if(target == 0) return 1;
        if(memo[target] != null) return memo[target];
        int ans = 0;
        for(int n: nums){
            if(target >= n) ans += helper(nums, target-n, memo);
        }
        return memo[target] = ans;
    }
}