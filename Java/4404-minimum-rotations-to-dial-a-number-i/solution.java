class Solution {
    public int minRotations(String s) {
        int total_rotations = 0;
        int current = 0; 
        for(int i=0; i<s.length(); i++) {
            int num = s.charAt(i)-'0';
            int difference = Math.abs(current - num);
            int rotation = Math.min(difference, 10-difference);
            total_rotations += rotation;
            current = num;            
        }
        return total_rotations;
    }
}
