class Solution {
    private boolean feasible(int[] nums, int k, int threshold){
        int count = 1;
        int total = 0;
        for(int num: nums){
            total += num;
            if(total > threshold){
                total = num;
                count++;
                if(count > k){
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        int left = max, right = sum;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(feasible(nums, k, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}