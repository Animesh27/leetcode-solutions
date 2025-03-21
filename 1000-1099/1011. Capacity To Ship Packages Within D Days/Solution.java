class Solution {
    public boolean feasible(int[] weights, int capacity, int days){
        int sum = 0, d = 1;
        for(int w: weights){
            sum += w;
            if(sum > capacity){
                sum = w;
                d++;
                if(d > days){
                    return false;
                }
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for(int w: weights){
            sum += w;
            max = Math.max(max, w);
        }
        int left = max, right = sum;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(feasible(weights, mid, days)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}