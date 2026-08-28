class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> allsubstring = new ArrayList<>();
        List<String> current = new ArrayList<>();
        find(s,allsubstring,current,0);
        return allsubstring;
    }

    public void find(String s, List<List<String>> allsubstring, List<String> current, int start){
        // base case
        if(start == s.length()) {
            allsubstring.add(new ArrayList<>(current));
            return;
        }
        for(int i= start; i<s.length(); i++) {
            if(ispalindrome(s,start,i)){
            current.add(s.substring(start,i+1));
            find(s,allsubstring,current,i+1);
            current.remove(current.size()-1);
            }

        }
    }


    public boolean ispalindrome(String s, int left, int right) {
        while(left <= right) {
        if(s.charAt(left) != s.charAt(right)) {
            return false;
        } 
        left++;
        right--;
        }
        return true;
    }
}
