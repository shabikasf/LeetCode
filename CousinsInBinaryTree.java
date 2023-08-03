//https://leetcode.com/problems/cousins-in-binary-tree/
//993. Cousins in Binary Tree

class Pair{
    TreeNode child;
    TreeNode parent;
    int depth;
    
    Pair(TreeNode child, TreeNode parent, int depth){
        this.child = child;
        this.parent = parent;
        this.depth = depth;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        HashMap<Integer, Pair> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root.val, new Pair(root, null, 0));
        int depth = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while(size-- > 0){
                root = queue.poll();
                if(root.left != null){
                    queue.add(root.left);
                    map.put(root.left.val, new Pair(root.left, root, depth));
                }
                if(root.right != null){
                    queue.add(root.right);
                    map.put(root.right.val, new Pair(root.right, root, depth));
                }
            }
        }
        
        Pair node1 = map.get(x);
        Pair node2 = map.get(y);
        
        if(node1.depth == node2.depth && node1.parent != node2.parent)
            return true;
        return false;
    }
}
