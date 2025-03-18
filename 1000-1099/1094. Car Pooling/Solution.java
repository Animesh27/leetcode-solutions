class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int currentPassengers = 0;
        for(int[] trip: trips){
            while(!pq.isEmpty() && pq.peek()[2] <= trip[1]){
                currentPassengers -= pq.poll()[0];
            }
            currentPassengers += trip[0];
            if (currentPassengers > capacity) return false;
            pq.offer(trip);
        }
        return true;
    }
}