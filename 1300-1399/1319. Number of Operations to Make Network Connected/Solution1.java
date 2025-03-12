class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)
            return -1;
        DSU dsu = new DSU(n);
        int count = 0;
        int ans = n;
        for(int[] edge: connections){
            if(dsu.union(edge[0], edge[1])){
                ans--;
            }
        }
        return ans-1;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    DSU(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i = 0;i<size;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public boolean union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep)
            return false;
        if(rank[x_rep] < rank[y_rep]){
            parent[x_rep] = y_rep;
            return true;
        } else if(rank[y_rep] < rank[x_rep]) {
            parent[y_rep] = x_rep;
            return true;
        }
        else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
            return true;
        }
    }

    public int find(int x){
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}