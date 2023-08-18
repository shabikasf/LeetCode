// https://leetcode.com/problems/shortest-path-in-binary-matrix/
// 1091. Shortest Path in Binary Matrix


class Pair{
    int row;
    int col;
    int dist;
    
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 1 && grid[0][0] == 0)
            return 1;
        
        if(grid[0][0] != 0)
            return -1;
        
        int n = grid.length;
        
        boolean[][] visited = new boolean[n][n];
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(0, 0, 1));
        
        visited[0][0] = true;
        
        int[] delRow = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
        int[] delCol = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
        
        int min = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().dist;
            
            queue.remove();
            for(int i=0; i<8; i++){
                int r = row + delRow[i];
                int c = col + delCol[i];
    
                if(r == n-1 && c == n-1 && grid[r][c] == 0){
                    min = Math.min(min, dist+1);
                    continue;
                }
                
                if(r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && grid[r][c] == 0){
                    visited[r][c] = true;
                    queue.add(new Pair(r, c, dist+1));
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
        
    }
}
