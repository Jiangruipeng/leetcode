package  easy.p111;

public class Solution {

    private int minDepth = Integer.MAX_VALUE;
 
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //DFS
        _minDepth(root, 1);
        return minDepth;
    }   


    private void _minDepth(TreeNode node, int depth){

        //if is leaf
        if(node.left == null && node.right == null){
            //found a path
            setDepth(depth);
        }else{
            if(node.left != null)  _minDepth(node.left, depth+1);
            if(node.right != null)  _minDepth(node.right, depth+1);
        }
    }

    private void setDepth(int depth){
        if (depth < minDepth){
            minDepth = depth;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.climbStairs(3));
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
