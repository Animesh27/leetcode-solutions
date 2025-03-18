class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int ans = 0, n1 = 1, n2 = 2;
        for(int i = 3;i<=n;i++){
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
        }
        return ans;
    }
}