class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        HashSet<Character> visited = new HashSet<>();
        for(int i=0; i<s.length();i++) {
            char ch = s.charAt(i);
            map.put(ch,i);
        }

        for(int i=0; i<s.length(); i++) {
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
