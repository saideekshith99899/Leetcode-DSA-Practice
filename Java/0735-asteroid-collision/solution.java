class Solution {
    public int[] asteroidCollision(int[] asteroid) {
        Stack<Integer> stack = new Stack<>();
        int n= asteroid.length;
        for(int i=0; i<n; i++){
            boolean destroyed = false;
            while(!stack.empty() && stack.peek() > 0 && asteroid[i] < 0) {

                if(Math.abs(asteroid[i]) > Math.abs(stack.peek())){
                    stack.pop();  // no break continu loop
                    
                }
                else if(Math.abs(asteroid[i]) == Math.abs(stack.peek())){
                    stack.pop();
                    destroyed = true;
                    break;

                    
                }
                else{
                    destroyed = true;
                    break;
                }
            }
        if(!destroyed) stack.push(asteroid[i]);
             
        }   

        int[] result = new int[stack.size()];
        for(int i= result.length - 1; i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
