package easy.p136;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int ret = 0;
        for (int i = 0; i <nums.length; i++){
            
            boolean b = set.add(nums[i]);
            if (b){
                ret = ret + nums[i];
            }else{
                ret = ret - nums[i];
            }
        }

        return ret;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        int ret = -1;
        for (Integer i : set){
            ret = i;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] testData = {4,1,2,1,2 };

        Solution solution = new Solution();
        System.out.println(solution.singleNumber(testData));
    }
}