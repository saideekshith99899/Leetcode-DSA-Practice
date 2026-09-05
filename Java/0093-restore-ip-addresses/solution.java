class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        find(s,current,result,0,0); // index, parts = 0
        return result;
    }
    public void find(String s,StringBuilder current, List<String> result, int index, int parts) {
        //base case
        if(parts == 4 && index == s.length()){
            result.add(current.toString());
            return;
        }
        
        for(int len=1;len<=3;len++) {
            if(index + len > s.length()) break;

            String part = s.substring(index,index+len);

            if(part.charAt(0) == '0' && part.length() > 1) {
                break;
            }

            if(Integer.parseInt(part) > 255) break;

            if(current.length() > 0) {
                current.append('.');
            }

            current.append(part);

            find(s,current,result,index+len,parts+1);

            current.delete(current.length() - len, current.length());
            if (current.length() > 0 &&
                current.charAt(current.length() - 1) == '.') {
                current.deleteCharAt(current.length() - 1);
            }
        }

    }
}
