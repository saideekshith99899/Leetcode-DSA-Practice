class pair implements Comparable<pair>{
    char ch;
    int freq;

    pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
    public int compareTo(pair t) {
        return this.freq - t.freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(char ch : s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int maxfreq = 0;
        for(int freq : map.values()) {
            maxfreq = Math.max(maxfreq, freq);
        }
        if(maxfreq > (n + 1) / 2)
        return "";
        // max heap 
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch: map.keySet()) {
            pq.add(new pair(ch,map.get(ch))); // ch,freq  - map
        }

        StringBuilder result = new StringBuilder();
        pair prev = null;
        while(pq.size() > 0) {
            pair top = pq.poll();
            result.append(top.ch);
            top.freq--;
            if(prev != null && prev.freq > 0) {
                pq.add(prev);
            }
            prev = top;
        }
        return result.toString();
    }
}
