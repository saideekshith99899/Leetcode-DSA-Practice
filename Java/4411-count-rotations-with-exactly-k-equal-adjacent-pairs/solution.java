class Solution {
    public int countRotations(String s, int k) {
        int result = 0;
        for(int rot = 0; rot < s.length(); rot++){
            String rotation = s.substring(rot) + s.substring(0,rot);
            int score = 0;
            for(int i=0;i<rotation.length()-1;i++) {
                if(rotation.charAt(i) == rotation.charAt(i+1)){
                   score++;
                }
            }
            if(score == k) result++;
        }
        return result;
    }
}
