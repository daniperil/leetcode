/**
 *Problem: 1464. Maximum Product of Two Elements in an Array
 *Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */

class Solution {
    public int maxProduct(int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        for(int num : nums){
            if(num>biggest){
                secondBiggest = biggest;
                biggest = num;
            } 
            else{
                secondBiggest = Math.max(secondBiggest, num);
            }
        }
        return (biggest-1)*(secondBiggest-1);
    }
}

/**
 *Time complexity: O(n)
 *We iterate over nums once, performing O(1)O(1)O(1) work at each iteration.
 *Space complexity: O(1)
 *We aren't using any extra space other than a few integers.
 */
