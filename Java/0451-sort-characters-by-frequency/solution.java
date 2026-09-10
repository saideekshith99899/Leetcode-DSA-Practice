class pair implements Comparable<pair> {
    int freq;
    char ch;

    pair(char ch , int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(pair t){
        return this.freq - t.freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        // max heap
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(char ch: map.keySet()) {
            pq.add(new pair(ch,map.get(ch)));
        }

        StringBuilder sb = new StringBuilder();
        
        while(pq.size()>0) {
            pair top = pq.poll();
            int k = top.freq;
            for(int i=0; i<k;i++) {
                sb.append(top.ch);
            }
        }
        return sb.toString();
    }
}
