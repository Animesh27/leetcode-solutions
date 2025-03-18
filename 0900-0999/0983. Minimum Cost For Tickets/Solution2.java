// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int day: days){
            set.add(day);
        }
        int n = days.length;
        int[] dp = new int[days[n-1] + 1];
        for(int i = 1;i<=days[n-1];i++){
            if(set.contains(i)){
                dp[i] = dp[i-1] + costs[0];
                int x = i - 7 >= 0 ? dp[i-7] + costs[1] : costs[1];
                int y = i - 30 >= 0 ? dp[i-30] + costs[2] : costs[2];
                dp[i] = Math.min(dp[i], Math.min(x, y));
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[days[n-1]];
    }
}