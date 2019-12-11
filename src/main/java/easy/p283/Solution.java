package easy.p283;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *[0,1,0,3,12]
 */
class Solution {

    
    public void moveZeroes(final int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        //first zero
        int front = 0;
        for (; front < nums.length; front++) {
            if (nums[front] == 0) {
                break;
            }
        }
        //first unhandle non-zero
        int end = front;

        while (end < nums.length) {

            // find non-zero for end index
            for (; end <nums.length; end++) {
                if (nums[end] != 0) {
                    break;
                }
            }
            //swap
            if(end != nums.length){
                nums[front] = nums[end];
                nums[end] = 0;
                front++;//next is zero, no need to search
            }

        }
    }

    public static void main(final String[] args) {
        final int[] testData1 = { 5,0, 1, 0, 3, 12,0,0,0,1,1,1 };
        final int[] testData2 = { 0,1,2,0 };

        final Solution solution = new Solution();
        solution.moveZeroes(testData2);
        print(testData2);
    }

    private static void print(final int[] data) {
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }
}