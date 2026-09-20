class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0)
            return 0;
        if(heights.length == 1)
            return heights[0];
        // maintain 2 stacks
        // one for index, one for height

        Stack<Integer> index = new Stack<>();
        Stack<Integer> height = new Stack<>();

        int maxArea = 0;
        index.push(0);
        height.push(heights[0]);

        // loop through array
        for(int i=1;i<heights.length;i++){
            // push if next Index height is more
            if(height.peek()<=heights[i]){
                height.push(heights[i]);
                index.push(i);
            }else{
                // logic if next index is smaller
                int prevIndex = 0;
                while(!height.isEmpty() && 
                    height.peek()>heights[i]){
                    prevIndex = index.pop();
                    int area = (i-prevIndex)*height.pop();
                    //System.out.println(area);
                    maxArea = maxArea>area?maxArea:area;   
                }
                index.push(prevIndex);
                height.push(heights[i]);
            }         
        }

        while(!height.isEmpty()){
            //System.out.println(index);
            //System.out.println(height);
            int area = (heights.length - index.pop())*height.pop();
            maxArea = maxArea>area?maxArea:area;
        }
        return maxArea;
    }
}

// 7,1,7,2,2,4
// i 4
// height    
// index    
// maxArea 8