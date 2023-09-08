/**
 *Problem: 118. Pascal's Triangle
 *Given an integer numRows, return the first numRows of Pascal's triangle.
 *In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) {
            return triangle;
        }
        
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            
            row.add(1);
            
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            row.add(1);
            triangle.add(row);
        }
        
        return triangle;
    }
}
/**
Complexity Analysis
Time Complexity: O(n2)O(n^2)O(n 
2
 )
Space Complexity: O(n2)O(n^2)O(n 
2
 ) */
