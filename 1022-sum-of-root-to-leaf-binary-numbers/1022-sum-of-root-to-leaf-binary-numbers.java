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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int value = (p.value << 1) | node.val;
            if (node.left == null && node.right == null) {
                sum += value;
            }
            if (node.left != null) {
                q.offer(new Pair(node.left, value));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, value));
            }
        }
        return sum;
    }
    class Pair {
        TreeNode node;
        int value;

        Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}