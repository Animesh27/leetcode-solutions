class Solution {
    public boolean feasible(int[] bloomDay, int minDays, int m, int k){
        int flowers = 0, bouquet = 0;
        for(int b: bloomDay){
            if(b > minDays){
                flowers = 0;
            } else {
                flowers++;
            }
            if(flowers == k){
                bouquet++;
                flowers = 0;
            }
        }
        return bouquet >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n){
            return -1;
        }
        int max = 0;
        for(int b: bloomDay){
            max = Math.max(max, b);
        }
        int left = 1, right = max;
        int minDays = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(feasible(bloomDay, mid, m, k)){
                right = mid-1;
                minDays = mid;
            } else {
                left = mid + 1;
            }
        }
        return minDays;
    }
}