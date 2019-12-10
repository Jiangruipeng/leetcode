package recursion.p118;

import java.util.ArrayList;
import java.util.List;

class SolutionIter {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 1; i <= numRows; i++){
            List<Integer> curRow = new ArrayList<Integer>();
            if(i == 1){
                curRow.add(1);
            }else{
                List<Integer> lastRow = ret.get(ret.size() -1);
                for (int j=0; j < i; j++){
                    if(j ==0 || j == i-1){
                        curRow.add(1);
                    }else{
                        curRow.add(lastRow.get(j-1) + lastRow.get(j));
                    }

                }
            }
            ret.add(curRow);
        }
        return ret;
    }

    
   

    public static void main(String[] args) {
        SolutionIter solution = new SolutionIter();
        // solution.generate(10000);
        System.out.println(solution.generate(5));
    }
}