class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder current = new StringBuilder();
        find(digits,current,0,keypad,result); //index=0;
        return result;
    }
    public void find(String digits, StringBuilder current, int index,String[] keypad, List<String> result) {
        //base case
        if(digits.length() == index) {
            result.add(current.toString());
            return;
        }
        String letter = keypad[digits.charAt(index) - '0']; // 2="abc";

        for(int i=0; i<letter.length();i++) {
            char ch = letter.charAt(i);
            current.append(ch);
            find(digits,current,index+1,keypad,result);
            current.deleteCharAt(current.length()-1);
        }
        

    }
}
