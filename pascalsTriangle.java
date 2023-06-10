// https://leetcode.com/problems/pascals-triangle/

// 118. Pascal's Triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        int dp[][] = new int[numRows+1][numRows+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            dp[i][1] = 1;
            dp[i][i] = 1;
        }
        for(int i=3; i<=numRows; i++){
            for(int j=2; j<numRows; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for(int i=1; i<=numRows; i++){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j=1; j<=i; j++){
                ans.add(dp[i][j]);
            }
            list.add(new ArrayList<>(ans));
        }
        return list;
    }
}
