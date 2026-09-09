class pair implements Comparable<pair> {
    int freq;
    int val;

    pair(int freq, int val) {
        this.freq = freq;
        this.val = val;
    }
    public int compareTo(pair t) {
        if(this.freq == t.freq) return this.val - t.val;
        return this.freq - t.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int ele : map.keySet()) {
            int freq = map.get(ele);
            pq.add(new pair(freq,ele));
            if(pq.size() > k) pq.remove();
        }

        int[] result = new int[k];
        for(int i=0; i<k;i++) {
            pair top = pq.poll();
            result[i] = top.val;
        }
        return result;
    }
}
