/**
 *Problem: 2352. Equal Row and Column Pairs
 *Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */

class Solution {
    public int equalPairs(int[][] grid) {
        int counter = 0;
        int n = grid.length;
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
               boolean pair = true;      
               for (int k = 0; k < n; ++k) {
                    if (grid[i][k] != grid[k][j]) {
                        pair = false;
                        break;
                    }
                }
                counter += pair ? 1 : 0;
            }   
        }
        return counter;
    }
}
