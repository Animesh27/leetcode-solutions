class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int ans = 0, latestEnd = 0;
        for(int[] meeting: meetings){
            int start = meeting[0], end = meeting[1];
            if(start > latestEnd+1){
                ans += (start - latestEnd-1);
            }
            latestEnd = Math.max(latestEnd, end);
        }
        ans += (days - latestEnd);
        return ans;
    }
}