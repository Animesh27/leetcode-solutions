class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for(String word: words){
            for(char c: word.toCharArray()){
                graph.put(c, new ArrayList<>());
                count.put(c, 0);
            }
        }
        int n = words.length;
        for(int i = 0; i<n-1;i++){
            String curr = words[i];
            String next = words[i+1];
            if(curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            for(int j = 0;j < Math.min(curr.length(), next.length());j++){
                if(curr.charAt(j) != next.charAt(j)){
                    graph.get(curr.charAt(j)).add(next.charAt(j));
                    count.put(next.charAt(j), count.get(next.charAt(j)) + 1);
                    break;
                }
            }
        }

        Deque<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(Character c : count.keySet()){
            if(count.get(c).equals(0)){
                q.add(c);
            }
        }
        while(!q.isEmpty()){
            char u = q.poll();
            sb.append(u);
            for(char adj: graph.get(u)){
                count.put(adj, count.get(adj) - 1);
                if(count.get(adj).equals(0)){
                    q.add(adj);
                }
            }
        }
        if(sb.length() < count.size()){
            return "";
        }
        return sb.toString();
    }
}