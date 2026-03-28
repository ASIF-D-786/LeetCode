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
    Map<Integer, Integer> map;
    private int idx;
    int[] postorder;
    private TreeNode helper(int[] inorder,int start,int end){
        if(start>end){
            return null;
        }
        int cur=postorder[idx--];
        int i=map.get(cur);
        TreeNode root=new TreeNode(cur);
        root.right=helper(inorder,i+1,end);
        root.left=helper(inorder,start,i-1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx=postorder.length-1;
        this.postorder=postorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder, 0, inorder.length-1);
    }
}