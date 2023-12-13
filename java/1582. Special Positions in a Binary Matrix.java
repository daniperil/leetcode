/**
 *Problem: 1582. Special Positions in a Binary Matrix
 *Given an m x n binary matrix mat, return the number of special positions in mat.
 *A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 */

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }
        
        int ans = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        ans++;
                    }
                }
            }
        }
        
        return ans;
    }
}

/**
 *Time complexity: O(m⋅n)O(m \cdot n)O(m⋅n)
 *To calculate rowCount and colCount, we iterate over each square once, which costs O(m⋅n)O(m \cdot n)O(m⋅n).
 *Next, we iterate over each square again to determine if it is special. Each iteration costs O(1)O(1)O(1), so in total we spend O(m⋅n)O(m \cdot n)O(m⋅n) here.
 *Space complexity: O(m+n)O(m + n)O(m+n)
 *rowCount has a size of mmm and colCount has a size of nnn.
 */
