class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int day = 0, applesEaten = 0;

        while (day < apples.length || !pq.isEmpty()) {
            // Add new apples for the current day
            if (day < apples.length && apples[day] > 0) {
                pq.add(new int[]{apples[day], day + days[day]});
            }

            // Remove rotten apples
            while (!pq.isEmpty() && pq.peek()[1] <= day) {
                pq.poll();
            }

            // Eat an apple if available
            if (!pq.isEmpty()) {
                int[] appleBatch = pq.poll();
                applesEaten++;
                if (appleBatch[0] > 1) {
                    pq.add(new int[]{appleBatch[0] - 1, appleBatch[1]}); // Reduce count and reinsert
                }
            }

            day++; // Move to the next day
        }
        return applesEaten;
    }
}
