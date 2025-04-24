class Solution {
    private int binarySearch(int[] row) {
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new  PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return b[0] - a[0];
        });
        for(int i = 0;i < mat.length;i++){
            int strength = binarySearch(mat[i]);
            pq.add(new int[]{strength, i});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = k-1;i>=0;i--) ans[i] = pq.poll()[1];
        return ans;
    }
}