class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            dsu.union(edge[0], edge[1]);
        }
        return dsu.find(source) == dsu.find(destination);
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
            rank[i] = 0;
        }
    }

    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y){
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep){
            return;
        }
        if(rank[y_rep] < rank[x_rep]){
            parent[y_rep] = x_rep;
        } else if(rank[x_rep] < rank[y_rep]){
            parent[x_rep] = y_rep;
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }
}