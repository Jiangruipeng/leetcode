package easy.p198;

import java.util.HashMap;

class Solution {

    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    /**
     * f(n) = max{[x0 + f(n-2)], [x1 + f(n-3)]}
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return _rob(nums, 0);
    }  

    private int _rob(int[] nums, int start) {
        //
        if(start >= nums.length){
            return 0;
        }
        Integer max = cache.get(start);

        if (max == null){
            int s1 = 0;
            int s2 = 0;
            if (start <nums.length ){
                s1 = nums[start] + _rob(nums, start+2);
            }
            if (start <nums.length -1 ){
                s2 = nums[start+1] + _rob(nums, start+3);
            }
            max = Math.max(s1,s2);
            cache.put(start, max);
        }

        return max;
    }  
   
    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};

        Solution solution = new Solution();
        int ret = solution.rob(testData);
        System.out.println(ret);
    }
}