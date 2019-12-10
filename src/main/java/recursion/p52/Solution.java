package recursion.p52;

/**
 * Validate Binary Search Tree
 */
public class Solution {

    //private int total = 0;

    //private int[][] matrix = null;

    public int totalNQueens(int n) {
        if (n <1) {
            return 0;
        }

        int[][] matrix = new int[n][n];
        int total = 0;
        int row = 0;

        return backtracking(matrix, row, total);
        //return total;
    }

    private int backtracking(int[][] matrix, int row, int total){
        for (int j = 0; j < matrix.length; j++) {
            
            if (no_conflict(matrix, row, j)){
                //place_queen(row, j);
                matrix[row][j]=1;

                if (row == matrix.length -1){
                    // found 1 solution
                    total++;
                }else{
                    //
                    total = backtracking(matrix, row+1, total);
                }
                //remove_queen
                matrix[row][j]=0;  
            }
        }
        return total;
    }

    private boolean no_conflict(int[][] matrix, int row, int col){
        //row check
        for (int i = 0; i< matrix[0].length; i++){
            if (matrix[row][i] == 1){
                return false;
            }
        }
        //col check
        for (int i = 0; i< matrix.length; i++){
            if (matrix[i][col] == 1){
                return false;
            }
        }
        //
        int row_temp = row;
        int col_temp = col;
        while (col_temp<matrix.length && row_temp <matrix.length ){
            if(matrix[row_temp][col_temp] == 1){
                return false;
            }
            row_temp++;
            col_temp++;
        }

         row_temp = row;
         col_temp = col;
        while (col_temp<matrix.length && row_temp >=0 ){
            if(matrix[row_temp][col_temp] == 1){
                return false;
            }
            row_temp--;
            col_temp++;
        }

        row_temp = row;
        col_temp = col;
       while (col_temp>=0 && row_temp >=0 ){
           if(matrix[row_temp][col_temp] == 1){
               return false;
           }
           row_temp--;
           col_temp--;
       }

       row_temp = row;
       col_temp = col;
      while (col_temp>=0 && row_temp <matrix.length ){
          if(matrix[row_temp][col_temp] == 1){
              return false;
          }
          row_temp++;
          col_temp--;
      }
      return true;

    }
   

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(8));
     
    }
}
