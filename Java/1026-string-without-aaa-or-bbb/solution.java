class pair implements Comparable<pair> {
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
    public String strWithout3a3b(int a, int b) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', a);
        map.put('b', b);

        // Max heap
        PriorityQueue<pair> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for(char ch : map.keySet()) {
            if(map.get(ch) > 0) {
                pq.add(new pair(ch, map.get(ch)));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {

            // Take character with highest frequency
            pair top = pq.poll();

            if(sb.length() >= 2 &&
               sb.charAt(sb.length() - 1) == top.ch &&
               sb.charAt(sb.length() - 2) == top.ch) {

                // top would create "aaa" or "bbb"
                pair next = pq.poll();

                sb.append(next.ch);
                next.freq--;

                if(next.freq > 0) {
                    pq.add(next);
                }

                // Put top back because we didn't use it
                pq.add(top);

            } else {

                // Add current character
                sb.append(top.ch);
                top.freq--;

                if(top.freq > 0) {
                    pq.add(top);
                }
            }
        }

        return sb.toString();
    }
}
