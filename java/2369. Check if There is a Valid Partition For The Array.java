

/**
 *Problem: 2369. Check if There is a Valid Partition For The Array
 *You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.
 *We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:
 *The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
 *The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
 *The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1. For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
 *Return true if the array has at least one valid partition. Otherwise, return false.
 */

public class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;

        if (n == 1) return false;

        boolean[] dp = new boolean[]{true, false, n > 1 && nums[0] == nums[1]};

        for (int i = 2; i < n; i++) {
            boolean current_dp = false;

            if (nums[i] == nums[i-1] && dp[1]) {
                current_dp = true;
            }
            else if (nums[i] == nums[i-1] && nums[i] == nums[i-2] && dp[0]) {
                current_dp = true;
            }
            else if (nums[i] - nums[i-1] == 1 && nums[i-1] - nums[i-2] == 1 && dp[0]) {
                current_dp = true;
            }

            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = current_dp;
        }

        return dp[2];
    }
}
