class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder ypart = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder xpart = new StringBuilder();

        for(char ch: s.toCharArray()) {
            if(ch == y) {
                ypart.append(ch);
            }
            else if(ch == x) {
                xpart.append(ch);
            }
            else{
                mid.append(ch);
            }
        }
        return ypart.toString()+ mid.toString() + xpart.toString();
    }
}
