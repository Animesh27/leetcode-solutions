class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()+1][word2.length()+1];
        return helper(word1, word2, word1.length(), word2.length(), memo);
    }

    public int helper(String word1, String word2, int m, int n, Integer[][] memo){
        if(m == 0) return n;
        if(n == 0) return m;
        if(memo[m][n] != null) return memo[m][n];
        int min = 0;
        if(word1.charAt(m-1) == word2.charAt(n-1)) {
            min = helper(word1, word2, m-1, n-1, memo);
        } else {
            int insertOp = helper(word1, word2, m, n-1, memo);
            int deleteOp = helper(word1, word2, m-1, n, memo);
            int replaceOp = helper(word1, word2, m-1, n-1, memo);
            min = Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
        }
        return memo[m][n] = min;
    }
}