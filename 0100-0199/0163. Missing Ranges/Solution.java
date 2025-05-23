class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> missingRanges = new ArrayList<>();
        if(n == 0) {
            missingRanges.add(Arrays.asList(lower, upper));
            return missingRanges;
        }
        if(lower < nums[0]){
            missingRanges.add(Arrays.asList(lower, nums[0]-1));
        }
        for(int i = 0;i<n-1;i++){
            if(nums[i+1] - nums[i] <= 1) continue;
            missingRanges.add(Arrays.asList(nums[i]+1, nums[i+1]-1));
        }
        if(upper > nums[n-1]){
            missingRanges.add(Arrays.asList(nums[n-1]+1, upper));
        }
        return missingRanges;
    }
}