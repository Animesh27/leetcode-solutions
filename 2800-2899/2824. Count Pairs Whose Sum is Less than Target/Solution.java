class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        Collections.sort(nums);
        int left = 0, right = nums.size() - 1;
        while(left < right){
            int val = nums.get(left) + nums.get(right);
            if(val < target){
                ans += (right - left);
                left++;
            } else {
                right--;
            }
        }
        // Replace this placeholder return statement with your code
        return ans;
    }
}