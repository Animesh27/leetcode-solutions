class Solution {
    public boolean feasible(int[] nums, int penalty, int maxOperations){
        long count = 0;
        for(int n: nums){
            count += (n % penalty == 0 ? (n/penalty) - 1 : n/penalty);
        }
        return count <= maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for(int n: nums){
            max = Math.max(max, n);
        }
        int low = 1, high = max, ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(nums, mid, maxOperations)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}