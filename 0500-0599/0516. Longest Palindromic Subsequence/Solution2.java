class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == reverse.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                } else {
                    cur[j] = Math.max(cur[j-1], prev[j]);
                }
            }
            prev = (int[]) cur.clone();
        }
        return prev[m];
    }
}