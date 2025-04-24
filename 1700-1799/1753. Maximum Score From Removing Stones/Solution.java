class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int ans = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            ans++;
            if(first - 1 > 0) pq.add(first - 1);
            if(second - 1 > 0) pq.add(second - 1);
        }
        return ans;
    }
}