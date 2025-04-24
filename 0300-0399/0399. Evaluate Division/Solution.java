class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        Map<String, List<Edge>> graph = new HashMap<>();
        for(int i = 0;i<n;i++){
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];
            graph.putIfAbsent(dividend, new ArrayList<>());
            graph.get(dividend).add(new Edge(divisor,quotient));
            if(quotient != 0.0){
                graph.putIfAbsent(divisor, new ArrayList<>());
                graph.get(divisor).add(new Edge(dividend, 1/quotient));
            }
        }
        double[] ans = new double[queries.size()];
        int count = 0;
        for(List<String> query: queries){
            String dividend = query.get(0);
            String divisor = query.get(1);
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                ans[count++] = -1.0;
            } else if(dividend.equals(divisor)){
                ans[count++] = 1.0;
            } else {
                Set<String> seen = new HashSet<>();
                double val = dfs(graph, dividend, divisor, 1, seen);
                ans[count++] = val;
            }
        }
        return ans;
    }

    public double dfs( Map<String, List<Edge>> graph, String dividend, String divisor, double accProduct, Set<String> seen){
        seen.add(dividend);
        double ret = -1.0;
        List<Edge> neighbors = graph.get(dividend);
        Optional<Edge> edge = neighbors.stream().filter(e -> e.to.equals(divisor)).findFirst();
        if(edge.isPresent()){
            ret = accProduct * edge.get().val;
        } else {
            for(Edge e: neighbors){
                if(!seen.contains(e.to)){
                    ret = dfs(graph, e.to, divisor, accProduct * e.val, seen);
                    if(ret != -1.0) break;
                }
            }
        }
        seen.remove(dividend);
        return ret;
    }
}
class Edge {
    String to;
    double val;
    Edge(String to, double val){
        this.to = to;
        this.val = val;
    }
}