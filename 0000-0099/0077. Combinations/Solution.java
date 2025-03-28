class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backTrack(n, k, new ArrayList<>(), 1, output);
        return output;
    }

    public void backTrack(int n, int k, List<Integer> list, int start, List<List<Integer>> output){
        if(k == list.size()){
            output.add(new ArrayList<>(list));
        } else {
            for(int i = start;i<=n;i++){
                list.add(i);
                backTrack(n, k, list,i+1, output);
                list.remove(list.size()-1);
            }
        }
    }
}