class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts;
        parts = path.split("/");        
        for(int i=0; i<parts.length; i++) {
            if(parts[i].equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            }
            else if(parts[i].equals(".") || (parts[i].equals("")))  {
                continue;
            }
            else{
                stack.push(parts[i]);
            }            
        }
        return  "/"+ String.join("/",stack);
    }
}
