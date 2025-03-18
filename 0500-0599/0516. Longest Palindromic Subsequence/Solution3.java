class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int[][] memo = new int[m+1][m+1];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return lcs(s, reverse, memo, m, m);
    }

    public int lcs(String s, String reverse, int[][] memo, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }
        if(memo[m][n] != -1){
            return memo[m][n];
        }
        if(s.charAt(m-1) == reverse.charAt(n-1)){
            memo[m][n] = 1 + lcs(s, reverse, memo, m-1, n-1);
        } else {
            memo[m][n] = Math.max(lcs(s, reverse, memo, m-1, n), lcs(s, reverse, memo, m, n-1));
        }
        return memo[m][n];
    }
}