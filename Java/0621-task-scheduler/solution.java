class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: tasks) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int maxFreq = 0;
        for(char ch: map.keySet()) {
            maxFreq = Math.max(maxFreq,map.get(ch));
        }
        int countMax = 0;
        for(char ch: map.keySet()) {
            if(maxFreq == map.get(ch)) {
                countMax++;
            }
        }

        int time = (maxFreq - 1) * (n+1) + countMax;
        return Math.max(tasks.length, time);
    }
}
