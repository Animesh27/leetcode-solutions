class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backTrack(output, nums, new ArrayList<>());
        return output;
    }

    public void backTrack(List<List<Integer>> output, int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            output.add(new ArrayList<>(list));
            return;
        }
        for(int n: nums){
            if(!list.contains(n)) {
                list.add(n);
                backTrack(output, nums, list);
                list.remove(list.size()-1);
            }
        }
    }
}