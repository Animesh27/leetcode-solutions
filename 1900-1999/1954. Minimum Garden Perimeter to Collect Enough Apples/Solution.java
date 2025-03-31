class Solution {
    public boolean feasible(long n, long neededApples) {
        long apples = 2 * n * (n + 1) * (2 * n + 1);
        return apples >= neededApples;
    }

    public long minimumPerimeter(long neededApples) {
        long low = 1, high = (long) 1e6, ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (feasible(mid, neededApples)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans * 8;
    }
}
