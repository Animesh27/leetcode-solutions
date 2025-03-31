class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int ans = 0;
        for(int[] meeting: meetings){
            if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < meeting[0]){
                merged.add(meeting);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], meeting[1]);
            }
        }
        ans += (merged.get(0)[0]-1);
        if(merged.get(merged.size()-1)[1] < days){
            ans += (days - merged.get(merged.size()-1)[1]);
        }
        for(int i = 0;i<merged.size()-1;i++){
            ans += (merged.get(i+1)[0] - merged.get(i)[1] - 1);
        }
        return ans;
    }
}