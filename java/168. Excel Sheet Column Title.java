/**
 *Problem: 168. Excel Sheet Column Title
 *Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *For example:
 *A -> 1
 *B -> 2
 *C -> 3
 *...
 *Z -> 26
 *AA -> 27
 *AB -> 28 
 *...
 */

public class Solution {
    //Iterative
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) ('A' + columnNumber % 26);
            result.insert(0, c);
            columnNumber /= 26;
        }
        return result.toString();
    }
}
/**
Complexity:
Time Complexity

The time complexity is O(log⁡26n)O(\log_{26} n)O(log 
26
​
 n), where nnn is the given columnNumber. This is because we're continuously dividing the number by 26 until it becomes zero.
Space Complexity for Iterative Approach:

The space complexity is O(log⁡26n)O(\log_{26} n)O(log 
26
​
 n) due to the list we use to store the Excel title characters. */
