class MyCircularQueue {
    int[] arr; 
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        arr = new int[k + 1];
        size = k + 1;
        front = 0;
        rear = 0;
    
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        arr[rear] = value;
        rear = (rear+1)%size;
      
        return true;

    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front+1)%size;
      
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        int rearindex = ( rear - 1 + size) % size;
        return arr[rearindex];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
       return (rear+1)%size == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
