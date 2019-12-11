package easy.p48;

import java.util.HashMap;

class Solution {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <=1){
            return;
        }
        int n = matrix.length;
        boolean[][] done = new boolean[n][n];
        for (int i = 0; i <n; i++){
            for (int j = 0; j < n; j++){
                int currentI = i;
                int currentJ = j;
                int current = matrix[currentI][currentJ];
                while(!done[currentI][currentJ]){
                    int nextI = currentJ;
                    int nextJ = n-1-currentI;
                    int next = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = current;

                    done[currentI][currentJ]=true;
                    currentI = nextI;
                    currentJ = nextJ;
                    current = next;
                }
            }
        }
    } 





    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    private static void print2D(int[][] data){
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data[0].length; j++){
                System.out.print(data[i][j]);
                System.out.print(',');
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[][] testdata = {{1,2,3,1},{4,5,6,1},{7,8,9,1},{0,0,7,7}};


        Solution solution = new Solution();
        // boolean ret = solution.isValidSudoku(testdata);
        solution.rotate(testdata);
        print2D(testdata);

    }
}