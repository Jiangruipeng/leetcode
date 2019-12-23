package  easy.p112;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null) return false;

        if(root.left == null && root.right == null){
            //is leaf
            if(sum == root.val){
                return true;
            }else{
                return false;
            }
        }

        boolean leftTrue = hasPathSum(root.left, sum - root.val);
        boolean rightTrue = hasPathSum(root.right, sum - root.val);
        return leftTrue || rightTrue;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;


        Solution solution = new Solution();
        boolean ret = solution.hasPathSum(root, 6);
        System.out.println(ret);
        // System.out.println(solution.climbStairs(3));
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
