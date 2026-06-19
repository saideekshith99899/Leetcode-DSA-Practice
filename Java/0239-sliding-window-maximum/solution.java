class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int[] result = new int[nums.length - k + 1];

    // delete from front when window size crosses 
    for(int i=0;i < nums.length ; i++){
    if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
    deque.pollFirst();
    }
    // same monotonic stack kind of logic.
    while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
        deque.pollLast();
    }   
    deque.offerLast(i);
     
    // max is always at front that was we did or removed from front
    if(i>=k-1){ // widnow size done 3 update result[] =  max
     result[i-k+1] = nums[deque.peekFirst()];
    }
    }
    return result;
    }
}
