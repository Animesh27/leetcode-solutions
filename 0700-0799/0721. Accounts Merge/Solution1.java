class Solution {

    public void dfs(List<String> mergedAccount, String email, Map<String, List<String>> graph, Set<String> visited){
        visited.add(email);
        mergedAccount.add(email);
        if(!graph.containsKey(email)){
            return;
        }
        for(String adj: graph.get(email)){
            if(!visited.contains(adj)){
                dfs(mergedAccount, adj, graph, visited);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        int accountListSize = accounts.size();
        for(List<String> account: accounts){
            int accountSize = account.size();
            String accountFirstEmail = account.get(1);
            for(int i = 2;i<accountSize;i++){
                String accountEmail = account.get(i);
                graph.putIfAbsent(accountFirstEmail, new ArrayList<>());
                graph.get(accountFirstEmail).add(accountEmail);
                graph.putIfAbsent(accountEmail, new ArrayList<>());
                graph.get(accountEmail).add(accountFirstEmail);
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(List<String> account: accounts){
            String name = account.get(0);
            String accountFirstEmail = account.get(1);
            if(!visited.contains(accountFirstEmail)){
                List<String> mergedAccount = new ArrayList<>();
                mergedAccount.add(name);
                dfs(mergedAccount, accountFirstEmail, graph, visited);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }
        return mergedAccounts;
    }
}