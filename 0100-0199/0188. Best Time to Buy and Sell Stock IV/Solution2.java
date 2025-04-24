class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // Optimization: treat as unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // Initialize: can't buy anything initially so set buy to -∞
        Arrays.fill(buy, Integer.MIN_VALUE);
        sell[0] = 0; // no transactions, no profit

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                // Try buying at this price after previous sell
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                // Try selling today from previously bought
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }

        return sell[k];
    }
}
