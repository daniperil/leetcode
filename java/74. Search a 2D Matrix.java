/**
 *Problem: 74. Search a 2D Matrix
 *You are given an m x n integer matrix matrix with the following two properties:
 *Each row is sorted in non-decreasing order.
 *The first integer of each row is greater than the last integer of the previous row.
 *Given an integer target, return true if target is in matrix or false otherwise.
 *You must write a solution in O(log(m * n)) time complexity.
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Binary search, to apply binary search, we need a one-dimensional array. We can treat our 2-D matrix as a one-dimensional array because of the matrix's sorted property. The fist integer of each row is greater than the last integer of the previous row, so we can think of the rows as being appended one after the other to form a single sorted array.
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m*n-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            int mid_val = matrix[mid/n][mid%n];

            if(mid_val == target){
                return true;
            }
            else if (mid_val < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }    
        return false;    
    }
}
/**
Complexity
Time Complexity
The time complexity is O(log⁡(m×n))O(\log(m \times n))O(log(m×n)), since we're effectively performing a binary search over the m×nm \times nm×n elements of the matrix.

Space Complexity
The space complexity is O(1)O(1)O(1) because we only use a constant amount of space to store our variables (left, right, mid, mid_value), regardless of the size of the input matrix.
 */
