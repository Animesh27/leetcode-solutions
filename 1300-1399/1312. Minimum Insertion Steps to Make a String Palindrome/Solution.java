class Solution {
    public int minInsertions(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=m;j++){
                if(reversed.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m - dp[m][m];
    }
}