package recursion.p509;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution {

    private static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
  
    public int fib(int N) {
        Integer cacheValue = cache.get(N);
        if(cacheValue != null){
            return cacheValue;
        } else{
            if (N == 1 || N == 0){
                return N;
            }else {
                return fib(N-1) + fib(N-2);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(5));
    }
}


