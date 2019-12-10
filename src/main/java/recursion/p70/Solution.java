package recursion.p70;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution {

    private static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
  

    public int climbStairs(int n) {
        Integer cacheValue = cache.get(n);
        if(cacheValue != null){
            return cacheValue;
        } else{
            int ret = 0;
            if (n == 1 || n == 0){
                ret = 1;
            }else {
                 ret = climbStairs(n-1) + climbStairs(n-2);
            }
            cache.put(n, ret);
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }
}


