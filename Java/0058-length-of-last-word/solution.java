class Solution {
    public int lengthOfLastWord(String s) {

        String[] words = s.split("\\s+");
        if(words.length == 0){
            return 0;
        }

        String ln  = words[words.length -1];

        int last = ln.length();


        return last;





        
    }
}
