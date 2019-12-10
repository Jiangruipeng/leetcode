package recursion.p119;

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> prev = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();

        //prev.add(0);
        for (int i = 1; i <= rowIndex+1; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i -1) {
                    cur.add(1); 
                }else {
                    cur.add(prev.get(j-1) + prev.get(j));
                }
            }
            List<Integer> tmp = prev;
            tmp.clear();
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(5));
    }
}