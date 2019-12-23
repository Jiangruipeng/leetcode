package medium.p145;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
    
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack  = new Stack<TreeNode>();
        if (root != null){
            stack.push(root);
        }

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            
            if(node.left == null && node.right == null){
                result.add(node.val);
                continue;
            }

            stack.push(new TreeNode(node.val));

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

        TreeNode node2 = new TreeNode();
        node2.val = 2;

        root.right = node2;

        TreeNode node3 = new TreeNode();
        node3.val = 3;

        node2.left = node3;


        Solution solution = new Solution();
        List<Integer> ret =  solution.postorderTraversal(root);
        System.out.println(ret);
    }
}


class TreeNode {
    public TreeNode(){};
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }