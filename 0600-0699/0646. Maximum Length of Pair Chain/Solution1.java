class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int ans = 1;
        Arrays.sort(pairs, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(pairs[i][0] > pairs[j][1]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
            ans = Math.max(ans, lis[i]);
        }
        return ans;
    }
}