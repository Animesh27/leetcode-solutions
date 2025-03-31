class Solution {
    public boolean feasible(int[] dist, int speed, double hour){
        double time = 0;
        for(int i = 0;i<dist.length-1;i++){
            time += (Math.ceil((double)dist[i]/speed));
        }
        time += ((double)dist[dist.length-1]/speed);
        return time <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        if(dist.length > Math.ceil(hour)){
            return -1;
        }

        int low = 1, high = (int) 1e7, ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(dist, mid, hour)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}