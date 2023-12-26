class Solution {
    public int mostWordsFound(String[] sentences) {
        int count=0;
        for(String sentence : sentences){
            String[] words = sentence.split("\\s+");

            int wordcount = words.length;

            if(wordcount > count){
                count = wordcount;
            }
        }

        return count;
        
    }
}
