package easy.p1;

import java.util.HashMap;

class Solution {

    private HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
   
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 1){
            return nums;
        }
        int[] result = new int[2];


        for (int i = 0; i < nums.length; i++){
            cache.put(nums[i], i);
        }

        cache.entrySet()
        .stream()
        .filter((entry)->{
            int pairkey =  target - entry.getKey();
            Integer parival = cache.get(pairkey);
            if(pairkey !=entry.getKey() && parival != null){
             result[0] = entry.getValue();
             result[1] = parival;
             return true;
            }else{
                return false;
            }
         })
         .findFirst();
         ;

         //deal with special case
        if ( target % 2 == 0 && result[0]== 0 && result[1] ==0){
            int half = target /2;
            int idx = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] == half){
                    result[idx++] = i;
                }
                if(idx == 2){break;}
            }
        }

         return result;
        
    }

    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();
        int[] ret = solution.twoSum(testData, -4);
        print(ret);
    }
}