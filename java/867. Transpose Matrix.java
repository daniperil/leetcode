/**
 *Problem: 867. Transpose Matrix
 *Given a 2D integer array matrix, return the transpose of matrix.
 *The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 */

class Solution {
    public int[][] transpose(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int arr[][]=new int[col][row];
        for(int i = 0; i<col; i++)
        {
            for(int j = 0; j<row; j++)
            {
                arr[i][j] = matrix[j][i];
            }
        }
        return arr; 
    }
}

/**
 *Complexity
 *Time Complexity: O(m * n) where m and n are the number of rows and columns in the matrix.
 *Space Complexity: O(m * n) for the transposed matrix.
 */
