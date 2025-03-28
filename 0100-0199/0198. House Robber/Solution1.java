class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        nums[1] = Math.max(nums[1], nums[0]);
        for(int i = 2;i<n;i++){
            nums[i] = Math.max(nums[i-1], nums[i]+ nums[i-2]);
        }
        return nums[n-1];
    }
}