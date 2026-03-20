class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i < s.length(); i++) {

            char ch = s.charAt(i);
            if(map.containsKey(ch)) {

                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch,1);
            }
        }


        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));


        // create string builder function

        StringBuilder result = new StringBuilder();

        for(int i= 0; i<list.size(); i++) {

            int freq = map.get(list.get(i));

            for(int j = 0; j< freq ; j++) {

                result.append(list.get(i));
            }

        }

        return result.toString();
        
    }
}
