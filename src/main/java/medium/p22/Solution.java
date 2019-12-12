package medium.p22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    private char[] parenthesis = {'(', ')'};

    public List<String> generateParenthesis(int n) {

        List<String> resultList = new ArrayList<String>();
        char[] result = new char[2*n];

        if(n <1){
            return resultList;
        }
        _generateParenthesis(result, 0, resultList);
        return resultList;
        
    }

    private void _generateParenthesis(char[] result, int start, List<String> resultList) {
        
        for (int i =0; i< parenthesis.length; i++){

            if(isValid(result, parenthesis[i])){
                //place parenthesis
                result[start] = parenthesis[i];

                if(start == result.length -1){
                    //reach the end ,found solution
                    resultList.add(new String(result));
                }else{
                    _generateParenthesis(result, start+1, resultList);
                }
                // remove parenthesis
                result[start] = 0;

            }
        }
    }

    private boolean isValid(char[] result, char c) {
        //{ cannot be more than half
        //
        int N = result.length/2;
        int n = 0;
        int check = 0;
        for (int i = 0; i < result.length; i++){
            if(result[i] == '('){
                check++;
                n++;
            }else if (result[i] == ')'){
                check--;
            }else {
                break;
            }

        }

        if(c == '('){
            check++;
            n++;
        }else if (c == ')'){
            check--;
        }

        if (check < 0 || n>N){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // char[] result = new char[2];

        // char c = result[0];
        // System.out.println((int)c);
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(0));
    }
}