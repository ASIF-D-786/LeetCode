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
    Map <Integer, Integer> map;
    private int idx;
    int[] preorder;
    private TreeNode helper(int[] inorder, int start,int end){
        if(start>end){
            return null;
        }
        int cur=preorder[idx++];
        int i=map.get(cur);
        TreeNode root=new TreeNode(cur);
        root.left=helper(inorder,start,i-1);
        root.right=helper(inorder,i+1,end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map=new HashMap<>();
        this.idx=0;
        this.preorder=preorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length-1);
    }
}