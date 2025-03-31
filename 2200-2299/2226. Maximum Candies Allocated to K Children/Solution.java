class Solution {
    public boolean feasible(int[] candies, long c, long k){
        long count = 0;
        for(int candy: candies){
            count += (candy/c);
        }
        return count >= k;
    }
    public int maximumCandies(int[] candies, long k) {
        long sum = Arrays.stream(candies).asLongStream().sum();
        if(sum < k){
            return 0;
        }
        long low = 1, high = Arrays.stream(candies).max().getAsInt(), ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(feasible(candies, mid, k)){
                ans = mid;
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return (int) ans;
    }
}