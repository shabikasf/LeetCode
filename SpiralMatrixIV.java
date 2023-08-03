//https://leetcode.com/problems/spiral-matrix-iv/
//2326. Spiral Matrix IV

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        int left = 0, right = n-1, top = 0, bottom = m - 1;
        int dir = 0;
        
        for(int[] arr: mat){
            Arrays.fill(arr, -1);
        }
        
        while(head != null && left <= right && top <= bottom){
            if(dir == 0){
                for(int i=left; i<=right; i++){
                    if(head != null){
                        mat[top][i] = head.val;
                        head = head.next;
                    }
                }
                dir++;
                top++;
            }
            
            else if(dir == 1){
                for(int i=top; i<=bottom; i++){
                    if(head != null){
                        mat[i][right] = head.val;
                        head = head.next;
                    }
                }
                dir++;
                right--;
            }
            
            else if(dir == 2){
                for(int i=right; i>=left; i--){
                    if(head != null){
                        mat[bottom][i] = head.val;
                        head = head.next;
                    }
                }
                dir++;
                bottom--;
            }
            else if(dir == 3){
                for(int i=bottom; i>=top; i--){
                    if(head != null){
                        mat[i][left] = head.val;
                        head = head.next;
                    }
                }
                dir++;
                left++;
            }
            
            dir = dir%4;
            
        }
        
        return mat;
    }
}
