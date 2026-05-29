class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();     // push purpose
        stack2 = new Stack<>();     // pop purpose
    }
    
    public void push(int x) {
        stack1.push(x);    
    }
    public int pop() {      // move if stack2 empty, then stack2.pop()
        if(stack2.empty()){
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        }
        return stack2.pop();
    }
     
    public int peek() {           // same as pop()
         if(stack2.empty()){
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        }
        return stack2.peek();
    }  
    
    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
