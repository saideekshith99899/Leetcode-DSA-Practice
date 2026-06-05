class Solution {
    public String removeDuplicateLetters(String s) {
     HashMap<Character, Integer> map = new HashMap<>();
     HashSet<Character> visited = new HashSet<>();
     Stack<Character> stack = new Stack<>();

     for(int i= 0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if(map.containsKey(ch)){
            map.put(ch,i);
        }
        else{
            map.put(ch,i);
        }
     }
     for(int i= 0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if(visited.contains(ch)) continue;    
        while(!stack.empty()) {
            if(stack.peek() > ch && map.get(stack.peek()) > i) {              
                visited.remove(stack.pop());             
            }          
            else{
                break;
            } 
           }
        stack.push(ch);     
        visited.add(ch);
     }
     StringBuilder sb = new StringBuilder();
     while(!stack.empty()) {
        sb.append(stack.pop());
     }
     return sb.reverse().toString();
    }
}
