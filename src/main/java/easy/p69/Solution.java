package easy.p69;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 
 * [1,3,4,5,9] [2,4,4,8,9,9]
 */
class Solution {

    private static int[] cache;

    static{
        int max = (int)Math.floor(Math.sqrt(Integer.MAX_VALUE));
        cache = new int[max+1];
        for (int i =0; i < max+1; i++){
            cache[i] = i*i;
        }
    }
    
    public int mySqrt(int x) {
        int left = 0; 
        int right =cache.length -1;

        while(left<=right){
            int mid = left + (right -left)/2;

            if(cache[mid] == x){
                return mid;
            }else if (cache[mid] > x){
                right = mid -1;
            }else {
                left = mid +1;
            }
        }

        return left -1;
    }

    public static void main(String[] args) {


       
        Solution solution = new Solution();
        int ret = solution.mySqrt(0);
        System.out.println(ret);
    }

    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }
}