class Solution {
    public boolean feasible(int[] ribbons, int length, int k){
        int count = 0;
        for(int r: ribbons){
            count += (r/length);
        }
        return count >= k;
    }
    public int maxLength(int[] ribbons, int k) {
        long sum = Arrays.stream(ribbons).asLongStream().sum();
        if(sum < k){
            return 0;
        }
        int low = 1, high = (int)1e5, ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(ribbons, mid, k)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}