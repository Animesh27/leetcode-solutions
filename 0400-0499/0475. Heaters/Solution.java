class Solution {
    public boolean feasible(int[] houses, int radius, int[] heaters){
        int i = 0, j = 0;
        int n = houses.length, m = heaters.length;
        while (i < n && j < m) {
            if (Math.abs(houses[i] - heaters[j]) <= radius) {
                i++;
            } else {
                j++;
            }
        }
        return i == n;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low = 0, high = (int) 1e9, ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(houses, mid, heaters)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}