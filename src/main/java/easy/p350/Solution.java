package easy.p350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 
 * [1,3,4,5,9] [2,4,4,8,9,9]
 */
class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null|| nums1.length==0 || nums2.length == 0){
            return new int[0];
        }
        List<Integer> ret = new ArrayList<Integer>();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i < nums1.length; i++){
            int key = nums1[i];
            Integer val = map.get(key);
            if(val == null){
                val = 0;
            }
            val++;
            map.put(key, val);
        }

        for (int i = 0; i < nums2.length; i++){
            int key = nums2[i];
            Integer val = map.get(key);
            if(val != null && val != 0){
                val--;
                map.put(key, val);
                ret.add(key);
            }
        }


       
        return ret.stream().mapToInt(i->i).toArray();

    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null|| nums1.length==0 || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1=0;
        int idx2=0;
        List<Integer> ret = new ArrayList<Integer>();

        while(idx1 <nums1.length && idx2 <nums2.length){
            int n1 = nums1[idx1];
            int n2 = nums2[idx2];
            if(n1 <n2){
                idx1++;
            }else if (n1 == n2){
                ret.add(n1);
                idx1++;
                idx2++;
            }else {
                idx2++;
            }
        }
        return ret.stream().mapToInt(i->i).toArray();

    }


    public static void main(String[] args) {
        int[] testData1 ={1,3,4,5,9,8,9} ;
        int[] testData2 = {2,4,4,8,9,9} ;

       
        Solution solution = new Solution();
        int[] ret = solution.intersect(testData1, testData2);
        System.out.println(ret);
    }
}