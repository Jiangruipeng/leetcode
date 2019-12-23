package medium.p106;

public class Solution {

 
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return _buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        
    }

    public TreeNode _buildTree(int[] inorder, int inS, int inE, int[] postorder, int pS, int pE) {

        if (inE - inS < 0){
            return null;
        }else if(inE - inS == 0 ){
            return new TreeNode(inorder[inS]);
        }else {
            //find root
            TreeNode root = new TreeNode(postorder[pE]);
            //find root in inorder arr
            int rootIdx = 0;
            for (int i = inS; i <= inE; i++){
                if (inorder[i] == postorder[pE]){
                    rootIdx = i;
                    break;
                }
            }

            //inorder left tree: inS -> rootIdx -1
            int left_tree_size = rootIdx - inS;
            root.left = _buildTree(inorder, inS, rootIdx-1, postorder, pS, pS + left_tree_size -1);
            //right: rootIdx+1 -> inE
            root.right = _buildTree(inorder, rootIdx +1, inE, postorder, pS + left_tree_size, pE-1);
            return root;
        }

    }
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = new int[] {1,2,3,4,5};
        int[] postorder = new int[] {2,1,5,4,3};
        TreeNode node = solution.buildTree(inorder, postorder);
        System.out.println(node);
        // System.out.println(solution.climbStairs(3));
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
