class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        Integer[] memo = new Integer[n+1];
        for(int i = 1;i*i <=n;i++){
            list.add(i*i);
            memo[i*i] = 1;
        }
        return helper(n, list, memo);
    }

    public int helper(int n, List<Integer> list, Integer[] memo){
        if(memo[n] != null) return memo[n];
        if(list.contains(n)) return 1;
        int min = Integer.MAX_VALUE;
        for(int num: list){
            if(n > num) min = Math.min(min, helper(n-num, list, memo) + 1);
        }
        return memo[n] = min;
    }
}