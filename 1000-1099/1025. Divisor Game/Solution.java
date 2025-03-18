class Solution {
    public boolean divisorGame(int n) {
        boolean[] game = new boolean[n+1];
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<i;j++){
                if(i%j == 0){
                    game[i] = game[i] || !game[i-j];
                }
            }
        }
        return game[n];
    }
}
