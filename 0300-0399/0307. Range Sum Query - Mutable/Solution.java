class NumArray {
    int[] nums;
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.tree = new int[4 * n];
        buildTree(0, n-1, 0);
    }

    private void buildTree(int start, int end, int index){
        if(start == end){
            tree[index] = nums[start];
        } else {
            int mid = (start + end)/2;
            buildTree(start, mid, 2 * index + 1);
            buildTree(mid + 1, end, 2 * index + 2);
            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
    }

    public void update(int index, int val) {
        updateHelper(0, 0, n - 1, index, val);
    }

    private void updateHelper(int treeIndex, int start, int end, int index, int val){
        if(start == end){
            nums[index] = val;
            tree[treeIndex] = val;
        } else {
            int mid = (start + end) / 2;
            if(index <= mid){
                updateHelper(2 * treeIndex + 1, start, mid, index, val);
            } else {
                updateHelper(2 * treeIndex + 2, mid + 1, end, index, val);
            }
            tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
        }
    }

    public int sumRange(int left, int right) {
        return queryHelper(0, n-1, left, right, 0);
    }

    private int queryHelper(int start, int end, int left, int right, int index){
        if(end < left || start > right){
            return 0;
        }
        if(left <= start && right >= end){
            return tree[index];
        }
        int mid = (start + end) / 2;
        int leftSum = queryHelper(start, mid, left, right, 2 * index + 1);
        int rightSum = queryHelper(mid + 1, end, left, right, 2 * index + 2);
        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */