class pair implements Comparable<pair> {
    int val;
    int freq;
    pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
    public int compareTo(pair t) {
        if(this.freq != t.freq){
            return this.freq - t.freq;
        }
        return t.val - this.val;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int num : nums) {
        map.put(num, map.getOrDefault(num,0)+1);
       } 
       // min heap create
       PriorityQueue<pair> pq = new PriorityQueue<>();
       for(int ele: map.keySet()) {
            pq.add(new pair(ele,map.get(ele))); // map - (ele,freq);
       }

       int[] result = new int[nums.length];
       int i=0;
       while(pq.size() > 0) {
        pair top = pq.poll();
        int x = top.freq;
            while(x > 0) {
                result[i] = top.val;
                i++;
                x--;
            }
        }
       return result;
    }
}
