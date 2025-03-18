class Solution {
    public int tribonacci(int n) {
        if(n <= 2){
            if(n <= 1){
                return n;
            } else {
                return 1;
            }
        }
        int ans = 0, a = 0, b = 1, c = 1;
        for(int i = 3;i<=n;i++){
            ans = a + b + c;
            a = b;
            b = c;
            c = ans;
        }
        return ans;
    }
}