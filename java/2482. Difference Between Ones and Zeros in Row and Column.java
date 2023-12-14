/**
 *Problem: ###. "Problem name"
 *You are given a 0-indexed m x n binary matrix grid.
 *A 0-indexed m x n difference matrix diff is created with the following procedure:
 *Let the number of ones in the ith row be onesRowi.
 *Let the number of ones in the jth column be onesColj.
 *Let the number of zeros in the ith row be zerosRowi.
 *Let the number of zeros in the jth column be zerosColj.
 *diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
 *Return the difference matrix diff.
 */

class Solution {
  public int[][] onesMinusZeros(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[] onesRow = new int[m];
    int[] onesCol = new int[n];

    Arrays.fill(onesRow, 0);
    Arrays.fill(onesCol, 0);

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        onesRow[i] += grid[i][j];
        onesCol[j] += grid[i][j];
      }
    }

    int[][] diff = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        diff[i][j] = 2 * onesRow[i] + 2 * onesCol[j] - n - m;
      }
    }

    return diff;
  }
}

/**
 *Time complexity: O(M∗N)O(M * N)O(M∗N)
 *Each cell in the matrix is traversed twice, once to find the ones count and store them in onesRow and onesCol. Then again to find the values in the matrix diff. Hence the total time complexity is equal to O(M∗N)O(M * N)O(M∗N).
 *Space complexity: O(M+N)O(M + N)O(M+N)
 *The only space we required apart from the matrix diff which is used to store the answer and is not considered as part of space complexity are the two arrays onesRow and onesCol to store the count of ones in the rows and columns. Therefore, the total space complexity is equal to O(M+N)O(M + N)O(M+N).
 */



