package easy.p7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int reverse(int x) {
        List<Integer> list = int2ReverseList(abs(x));

        if (x <0){
            return 0-list2Int(list);
        }else if (x == 0) {
           return 0;
        }else {
            return list2Int(list);
        }
    }

    public long abs(int x){
        long tmp = (long)x;
        return (tmp < 0) ? -tmp : tmp;
    }


    private List<Integer> int2ReverseList(long x){
        List<Integer> list = new ArrayList<Integer>();
        long Quotient = x ;

        while(Quotient> 0){
             Long remainder = Quotient %10;
             list.add(remainder.intValue());
             Quotient = Quotient /10;

        }
        return list;
    }

    private int list2Int(List<Integer> list){
        Long ret = list.get(0).longValue();
        //Collections.reverse(list);
        for (int i=0; i < list.size()-1; i++){
           ret = ret * 10 + list.get(i+1);
        }
        //overflow
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE){
            return 0;
        }
        return ret.intValue();
    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args) {
        // int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = { -2, 1, -5, 6 };

        Solution solution = new Solution();
        int ret = solution.reverse(0);
        System.out.println(ret);
    }
}