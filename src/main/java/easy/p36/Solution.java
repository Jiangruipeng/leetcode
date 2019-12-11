package easy.p36;

import java.util.HashMap;

class Solution {

    public boolean isValidSudoku(char[][] board) {
        //chek row
        for (int i = 0; i < board.length; i++){
           boolean ret = _isValidSudoku(board, i, i+1, 0, board[0].length);
           if (!ret){return false;}
        }
        //check col
        for (int i = 0; i < board[0].length; i++){
            boolean ret =  _isValidSudoku(board, 0, board.length, i, i+1);
            if (!ret){return false;}
        }
        //check subbox
        for (int i = 0; i < board.length/3; i++){
            for (int j = 0; j < board[0].length/3; j++){
                boolean ret =  _isValidSudoku(board, i*3, i*3+3, j*3, j*3+3);
                if (!ret){return false;}
            }
        }
        return true;
    }

    private boolean _isValidSudoku(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
        int[] checkExt = new int[10];

        for (int i= rowStart; i < rowEnd; i++){
            for (int j = colStart; j < colEnd; j++){
                char c = board[i][j];
                if(c != '.'){
                    int num = c - 48;
                    if(checkExt[num] == 1){
                        return false;
                    }
                    checkExt[num] = 1;
                }
                
            }
        }
        return true;

    }
  





    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
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
        boolean ret = solution.isValidSudoku(testdata);
        System.out.println(ret);
    }
}