package medium.p322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    private HashMap<Integer, Integer> map = new  HashMap<Integer, Integer>();
    
  
    public int coinChange(int[] coins, int amount) {
        
        return _coinChange(coins, amount);
    }

    private int _coinChange(int[] coins, int amount) {

        if(amount < 0){
            return -1;
        }else if (amount == 0){
            return 0;
        }

        Integer ret = map.get(amount);
        if (ret == null){
            ret = Integer.MAX_VALUE;
            for (int i =0; i < coins.length; i++){
    
                int sofsub = _coinChange(coins, amount-coins[i]);
                if(sofsub != -1){
                    //have a solution
                    ret = Math.min(ret, sofsub +1);
                }
            }
            if(ret == Integer.MAX_VALUE){
                ret = -1;
            }
            map.put(amount, ret);
        }

        return ret;
    }


    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {1, 2, 5,50,500};

        Solution solution = new Solution();
        int ret = solution.coinChange(testData, 9999);
        System.out.println(ret);
    }
}