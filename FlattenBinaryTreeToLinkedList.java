//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//114. Flatten Binary Tree to Linked List


class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for(int i=1; i<list.size(); i++){
            root.right = list.get(i);
            root.left = null;
            root = root.right;
        }
    }
    
    private void dfs(TreeNode root, List<TreeNode> list){
        if(root == null)
            return;
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
        
    }
}
