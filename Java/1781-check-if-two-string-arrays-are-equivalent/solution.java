class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String word11 = String.join("",word1);
        String word22 = String.join("",word2);

        return word11.equals(word22);
        
    }
}
