package medium.p102;

import java.util.ArrayList;
import java.util.List;


public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if (root == null){
            return resultList;
        }

        // BFS
        List<TreeNode> rootList =  new ArrayList<TreeNode>();
        rootList.add(root);

        _levelOrder(rootList, resultList);

        return resultList;
    }
    
    private void _levelOrder(List<TreeNode> nodes,List<List<Integer>> resultList) {

        if(nodes.size() == 0){
            return;
        }


        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> subNodeList = new ArrayList<TreeNode>();
        for (TreeNode n : nodes){
            list.add(n.val);
            if (n.left != null){
                subNodeList.add(n.left);
            }
            if (n.right != null){
                subNodeList.add(n.right);
            }
        }
        resultList.add(list);

        _levelOrder(subNodeList, resultList);
    }  
   

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        TreeNode root = new TreeNode();
        root.val = 1;
        Solution2 solution = new Solution2();
        System.out.println(solution.levelOrder(root));

        
    }
}


// class TreeNode {
//     public TreeNode(){};
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }