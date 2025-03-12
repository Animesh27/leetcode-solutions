class Solution {
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for(int[] edge: edges){
            if(!dsu.union(edge[0], edge[1]))
                return edge;
        }
        return new int[]{};
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

    public boolean union(int x, int y){
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep){
            return false;
        }
        if(rank[y_rep] < rank[x_rep]){
            parent[y_rep] = x_rep;
        } else if(rank[x_rep] < rank[y_rep]){
            parent[x_rep] = y_rep;
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
        return true;
    }

    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
}