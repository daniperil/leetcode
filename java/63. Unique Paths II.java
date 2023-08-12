/**
 *Problem: 63. Unique Paths II
 *You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Dynamic programming dp    
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1){
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] previous = new int[n];
        int[] current = new int[n];
        previous[0] = 1;

        for (int i = 0; i < m; i++) {
            current[0] = obstacleGrid[i][0] == 1 ? 0 : previous[0];
            for (int j = 1; j < n; j++) {
                current[j] = obstacleGrid[i][j] == 1 ? 0 : current[j-1] + previous[j];
            }
            //It is using the System.arraycopy method to copy elements from the current array to the previous array.
            /**
            current: This is the source array from which elements will be copied.
0: This is the starting index in the source array from which the copying will begin.
previous: This is the destination array where the elements will be copied to.
0: This is the starting index in the destination array where the copied elements will be placed.
n: This is the number of elements to be copied from the source array to the destination array. */
            System.arraycopy(current, 0, previous, 0, n);
        }

        return previous[n-1];

    }
}
/**
Complexity
Time Complexity: O(m×n)O(m \times n)O(m×n)
Space Complexity: O(n)O(n)O(n)

This solution is optimal in terms of both time and space complexity. It efficiently computes the number of unique paths by building upon previous calculations. */

