//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//103. Binary Tree Zigzag Level Order Traversal


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);
        while(!q.isEmpty()){
            int c = q.size();
            List<Integer> ans = new ArrayList<>();
            while(c > 0){
                root = q.poll();
                if(root != null)
                    ans.add(root.val);
                if(root != null && root.left != null)
                    q.add(root.left);
                if(root != null && root.right != null)
                    q.add(root.right);
                c--;
            }
            if(!flag){
                Collections.reverse(ans);
            }
            flag = !flag;
            res.add(new ArrayList<>(ans));
            
        }
        return res;
    }
}
