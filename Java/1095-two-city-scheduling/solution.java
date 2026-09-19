class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int n = costs.length / 2;
        for(int i=0; i< costs.length; i++){
            if(i < n){
                sum = sum + costs[i][0];
            }
            else{
                sum = sum + costs[i][1];
            }
        }
        return sum;
    }
}
