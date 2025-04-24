class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Integer[][][] memo = new Integer[strs.length+1][m+1][n+1];
        return helper(strs, strs.length-1, m, n, memo);
    }

    public int helper(String[] strs, int index, int m, int n, Integer[][][] memo){
        // Base cases
        if (index < 0) return 0;
        if (memo[index][m][n] != null) return memo[index][m][n];

        int[] count = getCount(strs[index]);

        // Don't take current string
        int notTake = helper(strs, index - 1, m, n, memo);

        // Take current string if possible
        int take = 0;
        if (m >= count[0] && n >= count[1]) {
            take = 1 + helper(strs, index - 1, m - count[0], n - count[1], memo);
        }

        memo[index][m][n] = Math.max(take, notTake);
        return memo[index][m][n];
    }

    public int[] getCount(String s){
        int[] res = new int[2];
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }
}