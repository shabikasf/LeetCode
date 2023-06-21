//https://leetcode.com/problems/path-sum-ii/
//113. Path Sum II

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        solve(root, res, new ArrayList<>(), targetSum);
        return res;
    }
    
    private void solve(TreeNode root, List<List<Integer>> res, List<Integer> ans, int targetSum){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                ans.add(root.val);
                res.add(new ArrayList<>(ans));
                ans.remove(ans.size()-1);
                return;
            }
        }
        ans.add(root.val);
        solve(root.left, res, ans, targetSum - root.val);
        solve(root.right, res, ans, targetSum - root.val);
        ans.remove(ans.size()-1);
        
    }
}
