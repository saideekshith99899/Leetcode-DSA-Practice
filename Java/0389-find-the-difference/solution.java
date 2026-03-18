class Solution {
    public char findTheDifference(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){

            char a = s.charAt(i);

            if(map.containsKey(a))
            {
                map.put(a, map.get(a)+1);
            }
            else{
                map.put(a,1);
            }
        }
        for(int i=0;i<t.length();i++) {    

            char b = t.charAt(i);

            if(!map.containsKey(b) || map.get(b) == 0){

               return b; 
               
            }    
              map.put(b,map.get(b) - 1);              
        }

        return ' ';     
        
    }
}
