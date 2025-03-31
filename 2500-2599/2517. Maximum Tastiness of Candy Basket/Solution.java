class Solution {
    public boolean feasible(int[] price, int tastiness, int k){
        int count = 1;
        int prev = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - prev >= tastiness) {
                count++;
                prev = price[i];
            }
            if (count >= k) return true;
        }
        return false;
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int low = 0, high = price[n-1] - price[0], ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(price, mid, k)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}