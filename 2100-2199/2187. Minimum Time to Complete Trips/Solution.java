class Solution {
    public boolean feasible(int[] time, long minTime, int totalTrips){
        long count = 0;
        for(int t: time){
            count += (minTime/t);
            if (count >= totalTrips) return true;
        }
        return count >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int minTime = Integer.MAX_VALUE;
        for(int t: time){
            minTime = Math.min(minTime, t);
        }
        long low = minTime, high = (long)totalTrips * minTime, ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(feasible(time, mid, totalTrips)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}