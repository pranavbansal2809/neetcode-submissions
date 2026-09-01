class Solution {
    public int maxArea(int[] heights) {
        int maxWater=0, i=0, j=heights.length-1;

        while(i<j){
            maxWater = Math.max(maxWater, (j-i)*Math.min(heights[i], heights[j]));
            if(heights[i]>heights[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxWater;
    }
}
