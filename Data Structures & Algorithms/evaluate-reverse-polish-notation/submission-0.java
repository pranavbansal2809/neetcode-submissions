class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(stack.isEmpty()){
                stack.add(Integer.valueOf(tokens[i]));
                continue;
            }
            switch(tokens[i]){
                case "+": result = stack.pop() + stack.pop();
                        stack.add(result);
                        break;
                case "-": result = -(stack.pop() - stack.pop());
                        stack.add(result);
                        break;
                case "/": int den = stack.pop();
                        result = stack.pop()/den;
                        stack.add(result);
                        break;
                case "*": result = stack.pop()*stack.pop();
                        stack.add(result);
                        break;
                default: stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}
