class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0 || cost.length ==1){
            return 0;
        }
        int minCost=0;
        for(int i=cost.length;i>=2;){
            minCost+=Math.min(cost[i-1],cost[i-2]);
            i=cost[i-2]<=cost[i-1]?i-2:i-1;
            //System.out.println(minCost);
            //System.out.println(i);
        }
        return minCost;
    }
}
