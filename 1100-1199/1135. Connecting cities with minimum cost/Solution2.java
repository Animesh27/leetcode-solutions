class Solution {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        DSU dsu = new DSU(n);
        int edgesUsed = 0;
        int minCost = 0;
        for(int[] connection: connections){
            int x = connection[0];
            int y = connection[1];
            if(dsu.union(x, y)){
                edgesUsed++;
                minCost += connection[2];
            }
        }
        return edgesUsed < n-1 ? -1 : minCost;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0;i<=n;i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y){
        int x_rep = find(x);
        int y_rep = find(y);
        if(x_rep == y_rep){
            return false;
        }
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
}