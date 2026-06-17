class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];
        //insert index from 0 ton n-1 in queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<deck.length; i++) {
            queue.offer(i);
        }
        Arrays.sort(deck); // sort the deck 
        int k = 0; // deck track
        for(int i=0; i< 2 * result.length; i=i+2) {
            result[queue.poll()] = deck[k]; 
            k++;
             if(!queue.isEmpty()) {
                queue.offer(queue.poll());
             }
        }
    return result;
    }
}
