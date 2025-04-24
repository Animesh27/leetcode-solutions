class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick: sticks){
            pq.add(stick);
        }
        int total = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            total += (first + second);
            pq.add(first + second);
        }
        return total;
    }
}