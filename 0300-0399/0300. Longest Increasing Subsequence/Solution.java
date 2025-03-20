class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        tail[0] = nums[0];
        int len = 1;
        for(int i = 1;i<n;i++){
            if(nums[i] > tail[len-1]){
                tail[len++] = nums[i];
            } else {
                int idx = ceilIndex(tail, 0, len-1, nums[i]);
                tail[idx] = nums[i];
            }
        }
        return len;
    }

    public int ceilIndex(int[] tail, int low, int high, int target){
        while( low < high){
            int mid = low + (high - low)/2;
            if(tail[mid] >= target){
                high = mid;
            } else {
                low  = mid+1;
            }
        }
        return high;
    }
}