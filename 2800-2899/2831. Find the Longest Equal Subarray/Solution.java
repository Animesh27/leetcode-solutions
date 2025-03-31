class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0, maxLength = 0, left = 0;
        for(int right = 0;right<nums.size();right++){
            map.put(nums.get(right), map.getOrDefault(nums.get(right), 0) + 1);
            maxCount = Math.max(maxCount, map.get(nums.get(right)));
            while((right - left + 1) - maxCount > k){
                map.put(nums.get(left), map.get(nums.get(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, maxCount);
        }
        return maxLength;
    }
}