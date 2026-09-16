class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();

        for(int i=0;i<n;i++){
            // pop until smaller values are present and update the result as well
            // initialise it's result as 0

            result[i] = 0;

            while(!stack.isEmpty() && temperatures[i]>stack.peek()){
                stack.pop();
                int curr = index.pop();
                result[curr] = i - curr;
            }
            stack.push(temperatures[i]);
            index.push(i);

        }
        return result;
    }
}

// 30,38,30,36,35,40,28
// stack - 
// index - 
// i - 0
// result - 0
