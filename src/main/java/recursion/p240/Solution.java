package recursion.p240;

/**
 * Validate Binary Search Tree
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        return searchMatrix(matrix, 0, matrix.length-1, 0, matrix[0].length-1, target);
    }


    private boolean searchMatrix(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd,  int target){
     
        //base case
        if(rowEnd < rowStart || colEnd < colStart){
            return false;
        }
        if(rowStart == rowEnd && colStart== colEnd){
            return matrix[rowStart][colStart] == target;
        }
        // divide
        // select pivot
        int pivotColumn = colStart + (colEnd - colStart) / 2;
        int pivotRow = rowStart;
        boolean foundGreater = false;
        for (int i = rowStart; i <= rowEnd; i++) {
            pivotRow = i;
           if( matrix[i][pivotColumn] == target){
               return true;
           }else if (matrix[i][pivotColumn] > target){
            //pivotRow = i;
            foundGreater = true;
            break;
           }
        }

        // combine
        if(foundGreater){
            return searchMatrix(matrix, pivotRow, rowEnd, colStart, pivotColumn-1, target) || searchMatrix(matrix, rowStart, pivotRow-1, pivotColumn+1, colEnd, target);
        }else{
            return searchMatrix(matrix, rowStart, rowEnd, pivotColumn+1, colEnd, target);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

       int[][] testData =  new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
       //int[][] testData = new int[][] {};
       //int[][] testData =  new int[][] {{-1,3}};
       boolean ret = solution.searchMatrix(testData, 20);
       System.out.println(ret);
    }
}
