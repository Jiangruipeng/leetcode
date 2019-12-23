package easy.p704;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = left + (right-left)/2;
        while (left <= right){
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = { -2, 1, -5, 6 };

        Solution solution = new Solution();
        // System.out.println(ret);
    }
}