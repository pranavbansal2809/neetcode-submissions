class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(minstack.isEmpty() || val<=minstack.peek()){
            minstack.add(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int val = stack.pop();
        if(val == minstack.peek()){
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
