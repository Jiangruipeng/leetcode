package easy.p66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 
 * [1,3,4,5,9] [2,4,4,8,9,9]
 */
class Solution {

    
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length<1){
            return digits;
        }

        List<Integer> result = new ArrayList<Integer>();
        boolean upgrade = true;
        int idx = digits.length-1;
        //changed part
        while (upgrade && idx >=0){
            int tmp = digits[idx] + 1;
            if (tmp == 10){
                tmp = 0;
                upgrade = true;
            }else{
                upgrade = false;
            }
            result.add(tmp);
            digits[idx] = tmp;
            if(idx == 0 && upgrade){
                result.add(1);
            }
            idx--;
        }
        //unchange part
        for (int i = idx; i>=0; i-- ){
            result.add(digits[i]);
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i->i).toArray();

    }

    public static void main(String[] args) {
        int[] testData1 ={1,3,4,5,9,8,9} ;
        int[] testData2 = {1} ;

       
        Solution solution = new Solution();
        int[] ret = solution.plusOne(testData2);
        print(ret);
    }

    private static void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]);
            System.out.print(',');
        }
    }
}