class Solution {
    public boolean feasible(int[] piles, int speed, int h){
        int hours = 0;
        for(int p: piles){
            hours = hours + (p / speed + ((p % speed == 0) ? 0 : 1));
            if(hours > h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p: piles){
            max = Math.max(max, p);
        }
        int left = 1, right = max;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(feasible(piles, mid, h)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}