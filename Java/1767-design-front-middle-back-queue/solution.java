class FrontMiddleBackQueue {
    Deque<Integer> left; // place front element
    Deque<Integer> right; // place back element 

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        // ifFull() - not present because no fixed k size
        left.offerFirst(val);
        if(left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
    }
    
    public void pushMiddle(int val) {
        if(left.size() == right.size()) {
            right.offerFirst(val);
        }
        else{
            left.offerLast(val);
        }
    }
    
    public void pushBack(int val) {
        right.offerLast(val);
        if(right.size() > left.size() + 1) {
            left.offerLast(right.pollFirst());
        }

    }
    
    public int popFront() {
        if(isEmpty()) return -1;
        int val ;
        if(!left.isEmpty()) {
            val = left.pollFirst();
        }
        else{
            val = right.pollFirst();
        }

        if(right.size() > left.size()+1){
            left.offerLast(right.pollFirst());
        }
        return val;
    }
    
    public int popMiddle() {
        if(isEmpty()) return -1;
        if(left.size() == right.size()) {
            return left.pollLast();
        }   
        else{
            return right.pollFirst();
        }           
    }
    
    public int popBack() {
       if(isEmpty()) return -1;   
        int val;
        val = right.pollLast();       
        if(left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }    
        return val;        
        
    }

    private boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
