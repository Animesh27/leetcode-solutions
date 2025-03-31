class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int ans = 1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1;i<n;i++){
            if(intervals[i][0] < pq.peek()){
                ans++;
            } else {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return ans;
    }
}