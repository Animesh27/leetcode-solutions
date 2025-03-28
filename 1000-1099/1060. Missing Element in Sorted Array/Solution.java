class Solution {
    public int missing(int index, int[] nums){
        return nums[index] - nums[0] - index;
    }
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if(k > missing(n-1, nums)){
            return nums[n-1] + k - missing(n-1, nums);
        }
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(missing(mid, nums) < k){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left-1] + k - missing(left-1, nums);
    }
}