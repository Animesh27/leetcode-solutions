class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        for(int house = 1;house < n;house++){
            int minColor = -1, secondMinColor = -1;
            for(int color = 0;color<k;color++){
                int cost = costs[house-1][color];
                if(minColor == -1 || cost < costs[house-1][minColor]){
                    secondMinColor = minColor;
                    minColor = color;
                } else if(secondMinColor == -1 || cost < costs[house-1][secondMinColor]){
                    secondMinColor = color;
                }
            }

            for (int color = 0; color < k; color++) {
                if (color == minColor) {
                    costs[house][color] += costs[house - 1][secondMinColor];
                } else {
                    costs[house][color] += costs[house - 1][minColor];
                }
            }
        }
        return Arrays.stream(costs[n-1]).min().getAsInt();
    }
}