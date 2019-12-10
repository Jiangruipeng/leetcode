package recursion.p912;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<Integer> sortArray(int[] nums) {

        int[] ret = merge_sort(nums, 0 , nums.length);
        return Arrays.stream(ret).boxed().collect(Collectors.toList());
        
    }

    private int[] merge_sort(int[] nums, int from , int to) {
        if (from == to -1) {
            int[] ret = new int[1];
            ret[0] = nums[from];
            return ret;
        }

        int len = (to - from);
        int pivot =  from + len/2 ;

        int[] leftArr = merge_sort(nums, from, pivot);
        int[] rightArr = merge_sort(nums, pivot, to);

        return merge(leftArr, rightArr);

    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int result_cursor =0;
        int left_cursor =0;
        int right_cursor =0;


        while (left_cursor < left.length && right_cursor < right.length){
            if (left[left_cursor] <= right[right_cursor]){
                result[result_cursor++] = left[left_cursor++];
            }else {
                result[result_cursor++] = right[right_cursor++];
            }
        }
  


        if (left_cursor == left.length) {
            while (right_cursor < right.length){
                result[result_cursor++] = right[right_cursor++];
            }
        } else if (right_cursor == right.length) {
            while (left_cursor < left.length){
                result[result_cursor++] = left[left_cursor++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[] {5,1,1,2,0,0};
        System.out.println(solution.sortArray(data)); 
    }
}

