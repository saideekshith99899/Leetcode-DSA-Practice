import java.util.*;
class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        if(dead.contains(start)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int level = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i =0; i<size; i++) {
                String curr = queue.poll();
                if(curr.equals(target)) return level;
                fillneighbors(queue,dead,visited,curr); 
            }
            level++;
        }
        return -1;
    }
    public void fillneighbors(Queue<String> queue,Set<String> dead,Set<String> visited, String curr){
        for(int i=0; i<4; i++){
            char[] chars = curr.toCharArray();
            char ch = chars[i];
            chars[i] = (ch == '0') ? '9' : (char) (ch-1);
            String dec = new String(chars);
            if(!dead.contains(dec) && !visited.contains(dec)){
                visited.add(dec);
                queue.offer(dec);
            }
            
            chars[i] = (ch == '9')? '0' : (char)(ch+1);
            String inc = new String(chars);
            if(!dead.contains(inc) && !visited.contains(inc)){
            visited.add(inc);
            queue.offer(inc);
            }
        }
    }
}
