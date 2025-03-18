// TLE - Time Complexity O(3^N)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return helper(0, days, costs);
    }

    public int helper(int i, int[] days, int[] costs){
        if (i >= days.length) return 0;

        int cost1 = costs[0] + helper(i + 1, days, costs);
        int j = i;
        while( j < days.length && days[j] < days[i] + 7) j++;
        int cost7 = costs[1] + helper(j, days, costs);
        j = i;
        while(j < days.length && days[j] < days[i] + 30) j++;
        int cost30 = costs[2] + helper(j, days, costs);
        return Math.min(cost1, Math.min(cost7, cost30));
    }
}