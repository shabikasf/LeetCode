//https://leetcode.com/problems/binary-tree-right-side-view/

//199. Binary Tree Right Side View

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int c = q.size();
            List<Integer> ans = new ArrayList<>();
            while(c >0){
                root = q.poll();
                if(root != null)
                    ans.add(root.val);
                if(root != null && root.left != null )
                    q.add(root.left);
                if(root != null && root.right != null)
                    q.add(root.right);
                    
                c--;  
            }
            if(ans.size() > 0)
                res.add(ans.get(ans.size()-1));

        }
        return res;
    }
    
}
