class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(boxGrid[i][j] == '*' || boxGrid[i][j] == '.') continue;
                if(boxGrid[i][j] == '#' && j != n-1){
                    int[] index = getIndex(boxGrid, i, j, n);
                    if(index[0] != i || index[1] != j){
                        boxGrid[index[0]][index[1]] = '#';
                        boxGrid[i][j] = '.';
                    }
                }
            }
        }
        char[][] ans = new char[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ans[i][j] = boxGrid[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(ans[i]);
        }
        return ans;
    }

    public int[] getIndex(char[][] boxGrid, int i, int j, int n){
        for(int k = j+1;k<=n-1;k++){
            if(boxGrid[i][k] == '#' || boxGrid[i][k] == '*') return new int[]{i,k-1};
        }
        return new int[]{i, n-1};
    }

    // Helper function to reverse an array
    private void reverse(char[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}