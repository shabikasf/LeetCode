//https://leetcode.com/problems/path-sum-iii/
//437. Path Sum III


class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        int count = solve(root, targetSum);
        int lp = pathSum(root.left, targetSum);
        int rp = pathSum(root.right, targetSum);
        return lp + rp + count;
    }

    private int solve(TreeNode root, long targetSum){
        if(root == null)
            return 0;
        int count = 0;
        if(targetSum - root.val == 0)
            count += 1;
        return solve(root.left, targetSum - root.val) + solve(root.right, targetSum - root.val)+ count;
    }
}
