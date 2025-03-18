class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> minDeque = new ArrayDeque<>(); // Stores indices
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int left = 0, maxLen = 0;
        for(int right = 0;right<n;right++){
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]){
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]){
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            while((nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()]) > limit){
                left++;
                // Remove outdated elements from queues
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}