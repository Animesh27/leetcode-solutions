class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        for(int i = 0;i<=m;i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == reverse.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][m];
    }
}