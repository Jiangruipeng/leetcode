package recursion.p118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        return pascalTriangle(numRows);
    }
    
    public List<List<Integer>> pascalTriangle(int numRows){
        if (numRows == 1){
            List ret = new ArrayList();
            List<Integer> data = new ArrayList<Integer>();
            data.add(1);
            ret.add(data);
            return ret;
        }
        
        return processPrevious(pascalTriangle(numRows -1));

    }

    public List<List<Integer>> processPrevious(List<List<Integer>> subList){
        List<Integer> lastRow = subList.get(subList.size() -1);
        
        List<Integer> curRow = new ArrayList<Integer>();
        int numRows = subList.size() + 1;
        for (int j=0; j < numRows; j++){
            if(j ==0 || j == numRows-1){
                curRow.add(1);
            }else{
                curRow.add(lastRow.get(j-1) + lastRow.get(j));
            }
            
        }
        subList.add(curRow);
        return subList;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(10000);
        //System.out.println(solution.generate(5));
    }
}