package easy.p189;

import java.util.HashMap;

/**
 * Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
class Solution {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return;
        }
        //approach1(nums,k);
        approach2(nums,k);

    }

    private void approach2(int[] nums, int k){
        k = k % nums.length;
        int[] part1 = new int[k];
        int j = 0;
        for (int i =nums.length -k ; i <nums.length; i++){
            part1[j++] = nums[i];
        }

        for (int i = nums.length -k-1; i >=0; i--){
            nums[i+k] = nums[i];
        }
        for (int i = 0; i <part1.length; i++){
            nums[i] = part1[i];
        }
    }

    private void approach1(int[] nums, int k){
        k = k % nums.length;
        for (int i =0; i <k; i++){
            approach1_r1(nums);
        }

    }
    private void approach1_r1(int[] nums){
        int last = nums[nums.length -1];
        for (int i = nums.length-1; i>0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }


    public static void main(String[] args){
        int[] testData = {};

        Solution solution = new Solution();
        solution.rotate(testData, 3);
        System.out.println(testData);
    }
}