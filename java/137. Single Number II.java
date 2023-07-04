/**
 *Problem: 137. Single Number II
 *Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

    // ~ Bitewise COMPLEMENT operator:
    // int num = 42;  // Binary: 00101010
    //int complement = ~num;  // Binary: 11010101

    // & Bitewise AND operator:
    //int a = 12;   // Binary: 1100
    //int b = 9;    // Binary: 1001
    //int result = a & b;   // Binary: 1000

    // ^= COMPOUND ASSIGNMENT operator:
    // The "^=" operator in Java is a compound assignment operator that combines the bitwise XOR operator (^) with the assignment operator (=).
    //int a = 5;   // Binary: 0101
    //int b = 3;   // Binary: 0011
    //a ^= b;      // Binary: 0110

    //The final modifier indicates that the variable num is a constant, meaning its value cannot be changed once assigned. In other words, it becomes read-only once it is initialized.

        for(final int num: nums){
            System.out.println(Integer.toBinaryString(ones));
            System.out.println(Integer.toBinaryString(twos));
            System.out.println("-----");
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }
    return ones;
    }
}
