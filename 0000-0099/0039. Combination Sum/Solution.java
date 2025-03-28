class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(output);
    }
    public void helper(int[] candidates, int target, int sum, List<Integer> list, int start){
        if(sum > target){
            return;
        }
        if(sum == target){
            output.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start;i<candidates.length;i++){
            list.add(candidates[i]);
            helper(candidates, target, sum + candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}