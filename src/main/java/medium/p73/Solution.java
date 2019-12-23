package medium.p73;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int[] rowCache = new int[rowSize];
        int[] colCache = new int[colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if( matrix[i][j] == 0){
                    rowCache[i] = 1;
                    colCache[j] = 1;
                }
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if( rowCache[i] == 1 || colCache[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        // int[] testData = {0,0,1,1,1,2,2,3,3,4};
        // int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();
        // int ret = solution.uniquePaths(0, 0);
        // System.out.println(ret);
    }
}