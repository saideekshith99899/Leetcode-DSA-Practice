class pair implements Comparable<pair> {
    int val;
    int freq;
    pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    public int compareTo(pair t) {
        return this.freq - t.freq;
    }
}
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:barcodes) {
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        // max heap 
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: map.keySet()) {
            pq.add(new pair(ele,map.get(ele))); // map - ele,freq
        }

        int[] result = new int[barcodes.length];
        pair prev = null;
        int i=0;
        while(pq.size() > 0) {
            pair top = pq.poll();
            result[i] = top.val;
            i++;
            top.freq--;
            if(prev != null && prev.freq > 0) {
                pq.add(prev);
            }
            prev = top;
        }
        return result;
    }
}
