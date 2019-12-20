package easy.p169;

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {

    private HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int majorityElement(int[] nums) {
        for (int i = 0; i< nums.length; i++){

            Integer val = cache.get(nums[i]);
            if(val != null){
                cache.put(nums[i], ++val);
            }else{
                cache.put(nums[i], 1);
            }
        }
        int max = 0;
        int maxNum = -1;
        for (Entry<Integer, Integer> entry : cache.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
                maxNum = entry.getKey();
            }
        }
        return maxNum;
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();
        int ret = solution.majorityElement(testData);

    }
}