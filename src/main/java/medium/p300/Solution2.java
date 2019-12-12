package medium.p300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {

    private Map<Integer,Integer> map = new HashMap<Integer, Integer>();


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++){
            int len = _lengthOfLIS(nums, i);
            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }

    /**
     * LIS ends with nums[start]
     * @param nums
     * @param start
     * @return
     */
    private int _lengthOfLIS(int[] nums, int start) {
        if (start  == 0){
            return 1;
        }


        Integer ret = map.get(start);
        if (ret == null){
            ret = 1;
            for (int i = 0; i < start; i++){
                if(nums[i] < nums[start]){
                    ret = Math.max(ret, _lengthOfLIS(nums, i)+1);
                }
            }
            map.put(start, ret);
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

        //int[] nums = {1,2,3,4,5,6,7,8,9,10};
        // int[] nums = {1};
        // System.out.println(nums.length);
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i <= 2500; i++){
            numList.add(i);
        }
        //int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {1,8,9,4,5,3,6};

        // int[] nums = numList.stream().mapToInt(i->i).toArray();
        Solution2 solution = new Solution2();
        int ret = solution.lengthOfLIS(nums) ;
        System.out.println(ret);
    }
}