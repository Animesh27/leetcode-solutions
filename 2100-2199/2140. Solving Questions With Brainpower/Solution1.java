class Solution {
    public long mostPoints(int[][] questions) {
        Long[] memo = new Long[questions.length];
        return helper(questions, 0, memo);
    }

    public long helper(int[][] questions, int index, Long[] memo){
        // base case
        if(index >= questions.length) return 0;
        if(memo[index] != null) return memo[index];
        // execution
        // if I skip the question, ans will be the recursion on next question
        // if I solve it then ans will be recursion on next solvable question
        long skip = helper(questions, index+1, memo);
        long solve = questions[index][0] + helper(questions, index + questions[index][1]+1, memo);
        // return
        return memo[index] = Math.max(skip, solve);
    }
}