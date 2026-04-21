class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;

       for(int i=0; i<cards.length; i++) {
        if(map.containsKey(cards[i])){

           result = Math.min(result, i - map.get(cards[i]) +1);
            // right - left +1 same logic
            //but here we do with indexes
            // here in the hashmap we store (key - index) pairs
            
        }
            map.put(cards[i], i);  
       }

       return result == Integer.MAX_VALUE ? -1: result;
        
    }
}
