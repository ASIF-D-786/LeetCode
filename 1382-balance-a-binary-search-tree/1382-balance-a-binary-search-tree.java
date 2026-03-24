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
    private void inorder(TreeNode root,ArrayList path){
        if(root==null){
            return;
        }
        inorder(root.left,path);
        path.add(root.val);
        inorder(root.right,path);
    }
    private TreeNode createBst(ArrayList<Integer> path,int low,int high){
        if(low>high){
            return null;
        }
        int mid=low+(high-low)/2;
        TreeNode root=new TreeNode(path.get(mid));
        root.left=createBst(path,low,mid-1);
        root.right=createBst(path,mid+1,high);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> path=new ArrayList<>();
        inorder(root,path);

        return createBst(path,0,path.size()-1);
    }
}