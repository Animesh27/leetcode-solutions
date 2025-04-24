class Solution {
    public int earliestAcq(int[][] logs, int n) {
        DSU dsu = new DSU(n);
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int ans = n-1;
        for(int[] log: logs){
            if(dsu.union(log[1], log[2])){
                ans--;
            }
            if(ans == 0) return log[0];
        }
        return -1;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
    }

    public boolean union(int x, int y){
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep) return false;
        if(rank[x_rep] < rank[y_rep]){
            parent[x_rep] = y_rep;
        } else if(rank[y_rep] < rank[x_rep]){
            parent[y_rep] = x_rep;
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
        return true;
    }

    public int find(int x){
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}