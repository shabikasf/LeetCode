//https://leetcode.com/problems/01-matrix/
// 542. 01 Matrix

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
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;        
        Queue<Pair> queue = new LinkedList<>();
        int[][] grid = new int[n][m];
        boolean visited[][] = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    grid[i][j] = 0;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        
        int[] moveRow = new int[]{-1, 1, 0, 0};
        int[] moveCol = new int[]{0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().dist;
            
            queue.remove();
            
            for(int i=0; i<4; i++){
                int r = row + moveRow[i];
                int c = col + moveCol[i];
                
                if(r >=0 && r < n && c >= 0 && c < m && !visited[r][c] && mat[r][c] == 1){
                    visited[r][c] = true;
                    grid[r][c] = dist + 1;
                    queue.add(new Pair(r, c, dist+1));
                }
            }
            
        }
        
        return grid;
    }
}
