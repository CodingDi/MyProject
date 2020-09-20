package DFS;

public class WordSearch {


        public boolean exist(char[][] board, String word) {
            // for each position in the board,we need to call helper function
            //   helper funciton: for given char,we check if its equal to the given index char in the word
            //   if yes,continue for 4 directions with next position in the word
            //   if not,return false
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(helper(board,word,0,i,j)){
                        return true;
                    }
                }
            }
            return false;


        }
        //for current position ar board matrix,we check if its equal to the char inm the word in index.
        //i and j: the row and col# of current processing character
        //index: all chars before index is valid and the same correspodin gthe input word
        private boolean helper(char[][] board,String word,int index,int i,int j){
            if(index==word.length()){
                return true;
            }
            boolean res=false;

            if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=word.charAt(index)){
                return false;
            }
            board[i][j]='.';//mark this one as visited
            res= helper(board,word,index+1,i-1,j)||helper(board,word,index+1,i,j-1)||helper(board,word,index+1,i,j+1)||helper(board,word,index+1,i+1,j);
            board[i][j]=word.charAt(index);
            return res;
        }

}
