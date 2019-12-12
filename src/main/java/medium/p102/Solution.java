package medium.p102;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Solution {

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
        List<Integer> list = nodes.stream().map(node->node.val).collect(Collectors.toList());
        resultList.add(list);
        List<TreeNode> subNodeList = nodes.stream()
        .map(n ->{
            List<TreeNode> tmp = new ArrayList<TreeNode>();
            if (n.left != null){
                tmp.add(n.left);
            }
            if (n.right != null){
                tmp.add(n.right);
            }
            return tmp;
        })
        .flatMap(List::stream)
        .collect(Collectors.toList());

        _levelOrder(subNodeList, resultList);
    }  

    public static void main(String[] args){
        //int[] testData = {0,0,1,1,1,2,2,3,3,4};
        TreeNode root = new TreeNode();
        root.val = 1;
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));

        
    }
}


class TreeNode {
    public TreeNode(){};
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }