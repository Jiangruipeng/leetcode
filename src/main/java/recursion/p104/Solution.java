package recursion.p104;

public class Solution {

 
    public int maxDepth(TreeNode root) {
        return _maxDepth(root);
    }

    private int _maxDepth(TreeNode node){
        if (node == null) {
            return 0;
        }
        // 1 mean the node itself;
        int left = 1 + _maxDepth(node.left);
        int right = 1 + _maxDepth(node.right);
        return Math.max(left, right);
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
