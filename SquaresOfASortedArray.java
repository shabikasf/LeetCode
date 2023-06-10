// https://leetcode.com/problems/squares-of-a-sorted-array/

// 977. Squares of a Sorted Array

class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length - 1;
        int res[] = new int[n+1];
        while(left <= right){
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if(l > r){
                res[n] = l;
                left++;
            }else{
                res[n] = r;
                right--;
            }
            n--;
        }
        return res;
    }
}
