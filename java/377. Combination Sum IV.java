/**
 *Problem: 377. Combination Sum IV
 *Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *The test cases are generated so that the answer can fit in a 32-bit integer.
 */

public class Solution {
    //Dynamic programming
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}
/**
Time Complexity: O(N * target). The outer loop runs target times, and for each iteration, we potentially check all N numbers in nums.
Space Complexity: O(target). The array dp will have target + 1 elements, each requiring constant space. So the overall space complexity is linear in terms of the target value. */
