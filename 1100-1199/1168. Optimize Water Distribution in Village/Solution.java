class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<Edge> edges = new ArrayList<>();
        for(int[] pipe: pipes){
            edges.add(new Edge(pipe[0], pipe[1], pipe[2]));
        }
        for(int i = 0;i<n;i++){
            edges.add(new Edge(0, i+1, wells[i]));
        }

        DSU dsu = new DSU(n+1);
        Collections.sort(edges, (a, b) -> a.weight-b.weight);
        int minCost = 0;
        for(Edge e: edges){
            if(dsu.union(e.src, e.dest)){
                minCost += e.weight;
            }
        }
        return minCost;
    }
}

class Edge {
    int src;
    int dest;
    int weight;
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
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