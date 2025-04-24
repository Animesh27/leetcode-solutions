class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        if(nums.length == 1) return 1;
        int left = 0, right = 1;
        while(right < nums.length){
            while(right < nums.length && nums[right] > nums[right - 1]) right++;
            maxLength = Math.max(maxLength, right - left);
            left = right;
            right++;
        }
        return maxLength;
    }
}