class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int index;
        Queue<Integer> queue = new LinkedList<>();
        // add this tickets elem into queue 
        for(int i=0; i<tickets.length; i++) {
            queue.offer(i);
        }
        //simulation part 
        int time = 0;
         while(!queue.isEmpty()) {                 
                index = queue.poll();
                time++;
                tickets[index]--;    
                if(tickets[index] == 0 && index == k ) return time;
                if(tickets[index] > 0) queue.offer(index);           
            
        }
       return time;
     }
}
