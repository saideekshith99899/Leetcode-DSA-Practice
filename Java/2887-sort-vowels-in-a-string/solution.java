
import java.util.*;
class Solution {

    private static boolean isVowel(char c){

        return "aeiouAEIOU".indexOf(c)!=-1;
    }


    public String sortVowels(String s) {
        List<Character> vowel = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                vowel.add(ch);
                indices.add(i);

            }
        }


        Collections.sort(vowel);

        char[] result = s.toCharArray();

        for(int j=0;j< vowel.size();j++){
            result[indices.get(j)] = vowel.get(j);

        }

        return new String(result);
    }
}
