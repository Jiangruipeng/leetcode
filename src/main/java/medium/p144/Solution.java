package medium.p144;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack  = new Stack<TreeNode>();
        if (root != null){
            stack.push(root);
        }

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }

        return result;
        
    }


    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        TreeNode root = new TreeNode();
        root.val = 1;
        Solution solution = new Solution();

        
    }
}


class TreeNode {
    public TreeNode(){};
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }