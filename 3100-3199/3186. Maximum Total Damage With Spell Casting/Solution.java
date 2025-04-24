
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> count = new HashMap<>();

        // Step 1: Count frequency of each damage value
        for (int damage : power) {
            count.put(damage, count.getOrDefault(damage, 0) + 1);
        }

        // Step 2: Sort unique damage values
        List<Integer> uniqueDamages = new ArrayList<>(count.keySet());
        Collections.sort(uniqueDamages);

        int n = uniqueDamages.size();
        long[] dp = new long[n];

        // Step 3: Compute DP with binary search for previous non-conflicting index
        for (int i = 0; i < n; i++) {
            int damage = uniqueDamages.get(i);
            long currentDamage = (long) damage * count.get(damage);

            // Find last index `j` where uniqueDamages[j] < uniqueDamages[i] - 2 (non-conflicting)
            int j = binarySearch(uniqueDamages, i, damage - 2);

            // DP Transition
            dp[i] = currentDamage;
            if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]); // Skip current damage
            if (j != -1) dp[i] = Math.max(dp[i], currentDamage + dp[j]); // Take current damage

        }

        return dp[n - 1];
    }

    // Binary search: Find largest index `j < i` where uniqueDamages[j] < limit
    private int binarySearch(List<Integer> uniqueDamages, int end, int limit) {
        int left = 0, right = end - 1, bestIdx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (uniqueDamages.get(mid) < limit) {
                bestIdx = mid; // Candidate for answer
                left = mid + 1; // Try for a larger valid index
            } else {
                right = mid - 1;
            }
        }
        return bestIdx; // Returns the best valid index or -1 if none found
    }
}
