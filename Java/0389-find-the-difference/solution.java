class Solution {
    public char findTheDifference(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            sb.append(ch);
        }
        for(char ch: t.toCharArray()){
            sb.append(ch);
        }
        char result = 0;
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            result = (char) (result ^ ch);
        }
    return result;
    }
}
