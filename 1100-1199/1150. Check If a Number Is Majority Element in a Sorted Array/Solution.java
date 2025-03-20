class Solution {
    private int firstOccurence(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else {
                if(mid == 0 || nums[mid] != nums[mid-1]){
                    return mid;
                }
                end = mid-1;
            }
        }
        return -1;
    }
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = firstOccurence(nums, target);
        return firstIndex != -1 && firstIndex + nums.length/2 < nums.length && nums[firstIndex+nums.length/2] == target;
    }
}