/**
 *Problem: 338. Counting Bits
 *Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

class Solution {
    //Dynamic Programming with Bit Manipulation
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        //i >> 1 is a right shift operation by 1 bit. It effectively divides i by 2, discarding the least significant bit. For example, if i is 5 (binary: 101), then i >> 1 is 2 (binary: 10).

        //i & 1 is a bitwise AND operation with 1. This operation extracts the least significant bit of i. If i is an even number, the result will be 0, and if i is an odd number, the result will be 1.
        for(int i = 1; i <= n; i++){
            ans[i] = ans[i>>1]+(i&1);
        }
        return ans;
    }
}
/**
Complexity Analysis
Time Complexity: O(n)O(n)O(n) — We iterate through the array once.
Space Complexity: O(n)O(n)O(n) — For the output array. */
