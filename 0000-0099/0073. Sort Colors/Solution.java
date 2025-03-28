class Solution {
    public void sortColors(int[] nums) {
        int start = 0, current = 0, end = nums.length - 1;
        while(current <= end){
            if(nums[current] == 0){
                nums[current] = nums[start];
                nums[start] = 0;
                current++;
                start++;
            } else if(nums[current] == 1){
                current++;
            } else {
                nums[current] = nums[end];
                nums[end] = 2;
                end--;
            }
        }
    }
}