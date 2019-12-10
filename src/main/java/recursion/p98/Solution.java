package recursion.p98;

/**
 * Validate Binary Search Tree
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // devide
        TreeNode left = root.left;
        TreeNode right = root.right;

        // conquer
        boolean isLeftBST = isValidBST(left);
        boolean isRightBST = isValidBST(right);

        if (isLeftBST && isRightBST) {
            // combine
            TreeNode maxLeft = left;
            if (maxLeft != null){
                while (maxLeft.right != null){
                    maxLeft = maxLeft.right;
                }
                if(maxLeft.val >= root.val){
                    return false;
                }
            }


            TreeNode minRight = right;

            if(minRight != null){
                while (minRight.left != null){
                    minRight = minRight.left;
                }
                if (minRight.val <= root.val){
                    return false;
                }
            }

            return true;

        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
