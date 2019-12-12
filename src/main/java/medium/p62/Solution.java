package medium.p62;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    private HashMap<String, Integer> map = new  HashMap<String, Integer>();
    
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        return _uniquePaths(m,n);
    }

    private int _uniquePaths(int m, int n) {

        if(m == 1 || n ==1){
            return 1;
        }
        String key = ""+m+":" +n;
        Integer val = map.get(key);
        if (val == null){
            //move right
            int s1 = _uniquePaths(m, n-1);

            //move down 
            int s2 =  _uniquePaths(m-1, n);
            val = s1 + s2;
            map.put(key, val);
        }
        return val;
    }
    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        //int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();
        int ret = solution.uniquePaths(0,0);
        System.out.println(ret);
    }
}