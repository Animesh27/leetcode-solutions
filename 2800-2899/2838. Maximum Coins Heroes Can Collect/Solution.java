class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int n = monsters.length, m = heroes.length;

        // Step 1: Store monsters and their coins in a list
        List<long[]> monsterCoinList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            monsterCoinList.add(new long[]{monsters[i], coins[i]});
        }

        // Step 2: Sort monster list by strength
        monsterCoinList.sort(Comparator.comparingLong(a -> a[0]));

        // Step 3: Compute prefix sum of coins
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + monsterCoinList.get(i)[1];
        }

        // Step 4: Find max coins each hero can collect
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            int index = findIndex(heroes[i], monsterCoinList);
            ans[i] = prefixSum[index + 1]; // Get coins sum up to valid index
        }

        return ans;
    }

    public int findIndex(int hero, List<long[]> monsterCoinList){
        int low = 0, high = monsterCoinList.size()-1, ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(monsterCoinList.get(mid)[0] <= hero){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}