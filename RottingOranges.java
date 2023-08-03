//https://leetcode.com/problems/rotting-oranges/
// 994. Rotting Oranges

class Pair{
    int row;
    int col;
    int time;
    
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        boolean visited[][] = new boolean[n][m];
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
                
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        
        int moveRow[] = new int[]{-1, 1, 0, 0};
        int moveCol[] = new int[]{0, 0, -1, 1};
        int tm = 0;
        int count = 0;
        
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            tm = Math.max(tm, queue.peek().time);
            
            queue.remove();
            
            for(int i=0; i<4; i++){
                int r = row + moveRow[i];
                int c = col + moveCol[i];
                
                if(r >= 0 && r < n && c >= 0 && c < m && !visited[r][c] && grid[r][c] == 1){
                    count++;
                    visited[r][c] = true;
                    grid[r][c] = 2;
                    
                    queue.add(new Pair(r, c, tm+1));
                }
            }
        }
        
        if(freshCount != count)
            return -1;
        return tm;
    }
}
