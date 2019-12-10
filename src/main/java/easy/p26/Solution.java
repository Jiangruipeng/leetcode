package easy.p26;

class Solution {
   
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int cursor = 1;

        for (int i = 1; i < nums.length; i ++){
            boolean foundDup = false;
            for (int j = 0; j < cursor; j++){
                if(nums[j] == nums[i]){
                    foundDup = true;
                    break;
                }
            }
            if(!foundDup){
                nums[cursor++] = nums[i];
            }
        }
        return cursor;
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {1,1};

        Solution solution = new Solution();
        int ret = solution.removeDuplicates(testData);
        System.out.println(ret);
        System.out.println(testData);
    }
}