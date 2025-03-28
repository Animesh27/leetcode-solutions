class Solution {
    public int maxRobbed(int[] nums, int start, int end){
        int t1 = 0, t2 = 0;
        for(int i = start;i<=end;i++){
            int temp = t1;
            t1 = Math.max(nums[i] + t2, t1);
            t2 = temp;
        }
        return t1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int firstRobbed = maxRobbed(nums, 0, n-2);
        int firstNotRobbed = maxRobbed(nums, 1, n-1);
        return Math.max(firstRobbed, firstNotRobbed);
    }
}