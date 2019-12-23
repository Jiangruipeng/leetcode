package easy.p69;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 
 * [1,3,4,5,9] [2,4,4,8,9,9]
 */
class Solution1 {
    
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 0; 
        int right =x;

        while(left<=right){
            int mid = left + (right -left)/2;

            if(mid == x /mid){
                return mid;
            }else if (mid > x /mid){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }

        return left -1;
    }

    public static void main(String[] args) {


       
        Solution1 solution = new Solution1();
        int ret = solution.mySqrt(17);
        System.out.println(ret);
    }

}