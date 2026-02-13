/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class info{
        int ht;
        int di;
        public info(int ht,int di){
            this.ht=ht;
            this.di=di;
        }
    }
    public static info dia(TreeNode root){
        if(root==null){
            return new info(0,0);
        }
        info li=dia(root.left);
        info ri=dia(root.right);

        int diameter=Math.max(li.ht+ri.ht,Math.max(li.di,ri.di));
        int height=Math.max(li.ht,ri.ht)+1;
        return new info(height,diameter);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return dia(root).di;
    }
}