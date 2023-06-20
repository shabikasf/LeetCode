//https://leetcode.com/problems/validate-binary-search-tree/
//98. Validate Binary Search Tree


class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root, res);
        for(int i=0; i<res.size()-1; i++){
            if(res.get(i) >= res.get(i+1))
                return false;
        }
        return true;
    }
    private void solve(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        solve(root.left, res);
        res.add(root.val);
        solve(root.right, res);
    }
}
