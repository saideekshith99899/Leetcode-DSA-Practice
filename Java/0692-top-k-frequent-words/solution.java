class pair implements Comparable<pair>{
    String word;
    int freq;
    pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
    public int compareTo(pair t) {
        if(this.freq != t.freq) {
            return this.freq - t.freq;
        }
        // if equal freq then pref to first word
        return t.word.compareTo(this.word);
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //create heap - min (beacause greater freq)
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(String word: map.keySet()) {
            pq.add(new pair(word,map.get(word)));  //word,freq - added
            if(pq.size() > k) pq.poll();
        }

        List<String> result = new ArrayList<>();
        while(pq.size() > 0) {
            pair top = pq.poll();
            result.add(top.word);
        }
        Collections.reverse(result); 
        return result;
    }
}
