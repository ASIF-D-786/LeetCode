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
    private void inorder(TreeNode root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        inorder(root.left,path);
        path.add(root.val);
        inorder(root.right,path);
    }
    private ArrayList<Integer> merge(ArrayList<Integer> path1,ArrayList<Integer> path2,ArrayList<Integer> path){
        int i=0,j=0;
        while(i<path1.size() && j<path2.size()){
            if(path1.get(i)<path2.get(j)){
                path.add(path1.get(i));
                i++;
            }
            else{
                path.add(path2.get(j));
                j++;
            }
        }
        while(i<path1.size()){
            path.add(path1.get(i));
            i++;
        }
        while(j<path2.size()){
            path.add(path2.get(j));
            j++;
        }
        return path;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> path1=new ArrayList<>();
        ArrayList<Integer> path2=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();

        inorder(root1,path1);
        inorder(root2,path2);

        return merge(path1, path2, path);
    }
}