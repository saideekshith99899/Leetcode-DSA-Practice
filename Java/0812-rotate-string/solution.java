class Solution {
    public boolean rotateString(String s, String goal) {


        return s.concat(s).contains(goal) && s.length()==goal.length();
        
    }
}
