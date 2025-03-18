class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m+1][n+1];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, memo, m, n);
    }

    public int lcs(String s1, String s2, int[][] memo, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }
        if(memo[m][n] != -1){
            return memo[m][n];
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            memo[m][n] = 1 + lcs(s1, s2, memo, m-1, n-1);
        } else {
            memo[m][n] = Math.max(lcs(s1, s2, memo, m-1, n), lcs(s1, s2, memo, m, n-1));
        }
        return memo[m][n];
    }
}