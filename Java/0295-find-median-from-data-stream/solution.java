class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
       
    }
    
    public void addNum(int num) {
      if(maxHeap.size() == 0) maxHeap.add(num);
      else{
        if(num < maxHeap.peek()) maxHeap.add(num);
        else minHeap.add(num);
      }

      if(minHeap.size() == maxHeap.size()+2) {
        maxHeap.add(minHeap.remove());
      }
      if(maxHeap.size() == minHeap.size()+2){
        minHeap.add(maxHeap.remove());
      }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size() + 1)
        return minHeap.peek();

        else if (maxHeap.size() == minHeap.size() + 1)
        return maxHeap.peek();

        else return (minHeap.peek() + maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
