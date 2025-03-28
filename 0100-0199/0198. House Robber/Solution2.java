class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int t1 = 0, t2 = 0;
        for(int i = 0;i<n;i++){
            int temp = t1;
            t1 = Math.max(nums[i]+t2, t1);
            t2 = temp;
        }
        return t1;
    }
}