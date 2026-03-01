class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> nodes = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        nodes.add(root);
        paths.add(String.valueOf(root.val));
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove(nodes.size() - 1);
            String path = paths.remove(paths.size() - 1);
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.right != null) {
                nodes.add(node.right);
                paths.add(path + "->" + node.right.val);
            }
            if (node.left != null) {
                nodes.add(node.left);
                paths.add(path + "->" + node.left.val);
            }
        }
        return result;
    }
}