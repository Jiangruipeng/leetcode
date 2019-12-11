package easy.p643;

import java.util.HashMap;

class Solution {

   
    public int maxSubArray(int[] nums) {

       int ret = _maxSubArray(nums, 0);
       //special case: all minus
       if (ret <0){
           //find max element
           int max = Integer.MIN_VALUE;
           for (int i = 0;i < nums.length;i++){
                if(nums[i]> max){
                    max = nums[i];
                }
           }
           ret = max;
       }
       return ret;

        
    }

    private int _maxSubArray(int[] nums, int start){
        if (start >= nums.length){
            return 0;
        }else if (start == nums.length -1){
            return nums[start];
        }
        if(nums[start] <0){
            return _maxSubArray(nums, start+1);
        } else{
            int p1Max = nums[start];
            int p1Tmp = nums[start];
            int idx = start+1;
            while (p1Tmp >0 && idx <=nums.length-1){
                p1Tmp = p1Tmp + nums[idx];
                p1Max = Math.max(p1Max, p1Tmp);
                idx++;
            }

            int p2Max = _maxSubArray(nums, idx);
            return Math.max(p1Max, p2Max);
        }
    }
  





    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }

    public static void main(String[] args){
        int[] testData = {};
        //int[] testData = {-1, -2};


        Solution solution = new Solution();
        int ret = solution.maxSubArray(testData);
        System.out.println(ret);
    }
}