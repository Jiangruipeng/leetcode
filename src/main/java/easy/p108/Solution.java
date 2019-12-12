package easy.p108;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return _sortedArrayToBST(nums, 0, nums.length);

        
    }

    private TreeNode _sortedArrayToBST(int[] nums, int start, int end) {
        //assert length >=1
        if(end - start < 1){
            return null;
        }else {
            int mid = start + (end - start)/2;

            TreeNode node = new TreeNode( nums[mid]);
            node.left = _sortedArrayToBST(nums, start, mid);
            node.right = _sortedArrayToBST(nums, mid+1, end);
            return node;
        }
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};

        Solution solution = new Solution();
        TreeNode node = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(node);

        
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }