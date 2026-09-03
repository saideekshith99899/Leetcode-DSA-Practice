class Solution {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
       List<String> result = new ArrayList<>();

       TrieNode root = new TrieNode();

       for(String word: words) {
        insert(root,word);
       }

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                find(board,row,col,root,result);
            }
        }
        return result;

    }

    public void insert(TrieNode root, String word){
        TrieNode current = root;
        for(char ch: word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.word = word;
    }

    public void find(char[][] board,int row, int col, TrieNode node,List<String> result) {
        if(row<0||col<0||row>=board.length||col>=board[0].length){
            return;
        }

        if(board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];

        if(node.children[ch-'a'] == null) return;

        node = node.children[ch-'a'];

        if(node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int i=0; i<4;i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            find(board,newRow,newCol,node,result);
        }
        board[row][col] = ch;
    }

}
