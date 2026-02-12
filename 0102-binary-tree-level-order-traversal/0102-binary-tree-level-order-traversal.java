class Solution {
    public static void levelorder(TreeNode root, List<List<Integer>> fresult){
        if(root==null) return;
        ArrayList<Integer> result=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode newNode=q.remove();
            if(newNode==null){
                fresult.add(result);
                result=new ArrayList<>();

                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                result.add(newNode.val);
                if(newNode.left!=null){
                    q.add(newNode.left);
                }
                if(newNode.right!=null){
                    q.add(newNode.right);
                }
            }
        }

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> fresult=new ArrayList<>();
        levelorder(root, fresult);
        return fresult;
    }
}