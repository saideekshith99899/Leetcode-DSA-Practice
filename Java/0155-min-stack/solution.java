class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    public MinStack() {
    
    }
    
    public void push(int value) {
        if(value <= min) {
            stack.push(min);
            min = value;
        }
        stack.push(value);
    }
    
    public void pop() {
        if(stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
