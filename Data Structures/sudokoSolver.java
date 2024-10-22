public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {

                           {'5','3','.','.','7','.','.','.','.'},
                           {'6','.','.','1','9','5','.','.','.'},
                           {'.','9','8','.','.','.','.','6','.'},
                           {'8','.','.','.','6','.','.','.','3'},
                           {'4','.','.','8','.','3','.','.','1'},
                           {'7','.','.','.','2','.','.','.','6'},
                           {'.','6','.','.','.','.','2','8','.'},
                           {'.','.','.','4','1','9','.','.','5'},
                           {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] ans = new char[board.length][board[0].length];
        sudokuSolver(0,0,board);
    }

    static void sudokuSolver(int r,int c,char[][] board){
         if (r >= board.length) {
             int i;
             for (i = 0; i < board.length; i++) {
                 for (int j = 0; j < board[0].length; j++) {
                     System.out.print(board[i][j] + " ");

                 }
                 System.out.println();
             }
             return;
         }
         else if (c == board[0].length){
             sudokuSolver(r+1,0,board);
         }
        else if(board[r][c] != '.'){
             sudokuSolver(r,c+1,board);
         }

        else {
            for (char i = '1'; i <= '9'; i++) {
                if (isSafe(r, c, i, board)) {
                    board[r][c] = i;
                    sudokuSolver(r, c + 1, board);
                    board[r][c] = '.';
                }
            }
        }
    }

    private static boolean isSafe(int r, int c, char i, char[][] board) {
        for (char[] chars : board) {
            if (chars[c] == i) {
                return false;
            }
        }
        for (int j = 0;j < board[0].length;j++){
            if (board[r][j] == i){
                return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int br = r - r%sqrt,bc = c - c%sqrt;

       for(int row = br;row < br+sqrt;row++){
           for(int col = bc;col < bc+sqrt;col++){
               if (board[row][col] == i){
                   return false;
               }
           }
       }

        return true;
    }
}
