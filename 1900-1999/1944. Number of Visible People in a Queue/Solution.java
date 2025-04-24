class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Monotonic decreasing stack

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            // Pop all smaller elements, as they are visible
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }

            // If stack is not empty, we can see one more taller person
            if (!stack.isEmpty()) {
                count++;
            }

            ans[i] = count;
            stack.push(heights[i]); // Maintain the decreasing order
        }

        return ans;
    }
}