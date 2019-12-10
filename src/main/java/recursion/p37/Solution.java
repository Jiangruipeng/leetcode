package recursion.p37;

/**
 * Validate Binary Search Tree
 */
public class Solution {

    private int count = 0;

    /**
     * The given board contain only digits 1-9 and the character '.'. You may assume
     * that the given Sudoku puzzle will have a single unique solution. The given
     * board size is always 9x9.
     * 
     * @param board
     */
    public void solveSudoku(char[][] board) {
        _solveSudoku(board, 0);
       // printBoard(board);
    }

    private boolean _solveSudoku(char[][] board, int startidx) {

        int idx = searchFirstBlank(board, startidx);
        int row = idx / 9;
        int col = idx % 9;
        count++;
        if(count % 100 == 0){
           // printBoard(board);
            //System.out.println("" + row + "," + col);
        }
        for (int i = 1; i <= 9; i++) {
            char c = (char) (48 + i);
            if (noConflict(board, row, col, c)) {
                // placeSoduku(board, row, col, i);
                board[row][col] = c;
                if (isLastStep(board, idx)) {
                    // found the solution
                    System.out.println("found the solution:");
                    printBoard(board);
                    return true;
                } else {
                    boolean ret = _solveSudoku(board, idx);
                    if (ret){
                        return true;
                    }
                }
                // removeSoduku(board, row, col, i);
                board[row][col] = '.';
            }
        }
        return false;
        
    }

    private void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]);
                System.out.print(',');
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    private int searchFirstBlank(char[][] board, int startidx) {
        int ret = -1;
        int row = startidx / 9;
        // int col = startidx % 9;
       sign:
        for (int i = row; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ('.' == board[i][j]) {
                    // found '.'
                    ret = i * 9 + j;
                   break sign;
                }
            }
        }
        return ret;
    }

    private boolean isLastStep(char[][] board, int startidx) {
        int ret = searchFirstBlank(board, startidx);
        return -1 == ret;
    }

    private boolean noConflict(char[][] board, int row, int col, char c){
        //check row
        for (int i = 0; i < board[0].length; i++){
            if (board[row][i] == c){
                return false;
            }
        }
        //check col
        for (int i = 0; i < board.length; i++){
            if (board[i][col] == c){
                return false;
            }
        }     
        //check block
        int row_block = row /3;
        int col_block = col /3;

        for (int i = row_block*3; i < row_block*3 + 3; i++){
            for (int j = col_block*3; j < col_block*3 + 3; j++){
                if(board[i][j] == c){
                    return false;
                }
            }
        }
        //all pass
        return true;
    }

    public static void main(String[] args) {
       char[][] testdata = {
       {'5','3','.','.','7','.','.','.','.'},
       {'6','.','.','1','9','5','.','.','.'},
       {'.','9','8','.','.','.','.','6','.'},
       {'8','.','.','.','6','.','.','.','3'},
       {'4','.','.','8','.','3','.','.','1'},
       {'7','.','.','.','2','.','.','.','6'},
       {'.','6','.','.','.','.','2','8','.'},
       {'.','.','.','4','1','9','.','.','5'},
       {'.','.','.','.','8','.','.','7','9'}};
       

        Solution solution = new Solution();
        solution.solveSudoku(testdata);
    }
}
