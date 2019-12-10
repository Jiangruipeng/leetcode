package easy.p217;

import java.util.Arrays;
import java.util.HashMap;


class Solution {

    /**
     * quick sort and find duplicate
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2){
            return false;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    /**
     * remove duplicate items
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2){
            return false;
        }
        int cursor = 1;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < cursor; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
            cursor++;
        }
        return false;
    }

    public static void main(String[] args){
        int[] testData = {4,1,2,3,1};

        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(testData));
    }
}