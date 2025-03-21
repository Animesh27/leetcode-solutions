class Solution {
    public boolean canBeFixed(int[] ranks, long fixedTime, int cars){
        long carsRepaired = 0;
        for(int r: ranks){
            carsRepaired += (long)(Math.sqrt(fixedTime * 1.0/ r));
        }
        return carsRepaired >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
        int max = 0;
        for(int r: ranks){
            max = Math.max(max, r);
        }
        long left = 1, right = (1L * max * cars * cars);
        while(left < right){
            long mid = left + (right - left)/2;
            if(canBeFixed(ranks, mid, cars)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}