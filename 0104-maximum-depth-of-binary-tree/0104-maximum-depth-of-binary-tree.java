class Solution {
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public int maxDepth(TreeNode root) {
        return height(root);
    }
}