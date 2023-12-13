'''
Problem: 1582. Special Positions in a Binary Matrix
Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
'''

class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        m = len(mat)
        n = len(mat[0])
        row_count = [0] * m
        col_count = [0] * n
        
        for row in range(m):
            for col in range(n):
                if mat[row][col] == 1:
                    row_count[row] += 1
                    col_count[col] += 1
        
        ans = 0
        for row in range(m):
            for col in range(n):
                if mat[row][col] == 1:
                    if row_count[row] == 1 and col_count[col] == 1:
                        ans += 1

        return ans
'''
Time complexity: O(m⋅n)O(m \cdot n)O(m⋅n)

To calculate rowCount and colCount, we iterate over each square once, which costs O(m⋅n)O(m \cdot n)O(m⋅n).

Next, we iterate over each square again to determine if it is special. Each iteration costs O(1)O(1)O(1), so in total we spend O(m⋅n)O(m \cdot n)O(m⋅n) here.

Space complexity: O(m+n)O(m + n)O(m+n)

rowCount has a size of mmm and colCount has a size of nnn.
'''
