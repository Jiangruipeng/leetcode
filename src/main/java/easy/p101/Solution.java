package easy.p101;

import java.util.Stack;

class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return _isSymmetric(root.left, root.right);
    }
 
    public boolean _isSymmetric(TreeNode left,TreeNode right) {
        if (left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }
        //both not null
        if(left.val != right.val){
            return false;
        }
        return _isSymmetric(left.left, right.right) && _isSymmetric(left.right, right.left);
    }

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        int[] testData = {-2, 1, -5, 6};

        Solution solution = new Solution();



        
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }