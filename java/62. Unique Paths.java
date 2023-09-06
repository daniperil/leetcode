/**
 *Problem: 62. Unique Paths
 *There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */

class Solution {
    //Combinatorial Mathematics
    //The number of unique paths can be seen as the number of ways to choose m-1 downs and n-1 rights, regardless of the order. In combinatorial terms, this is equivalent to m+n-2 Combined m-1
    //Combination (n choose k): A combination is a selection of k items from a set of n distinct items, where the order of selection does not matter. It is often denoted as C(n, k) or "n choose k."
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int i = 1; i <= m - 1; i++) {
            ans = ans * (n - 1 + i) / i;
        }
        return (int)ans;
    }
}
/**
Time Complexity: O(m)O(m)O(m) or O(n)O(n)O(n) — For calculating the combination.
Space Complexity: O(1)O(1)O(1) — Constant space.
 */
