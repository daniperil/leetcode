/**
 *Problem: 1913. Maximum Product Difference Between Two Pairs
 *The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
 *For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
 *Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
 *Return the maximum such product difference.
 */

class Solution {
    public int maxProductDifference(int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int num: nums){
            if(num>biggest){
                secondBiggest = biggest;
                biggest = num;
            } else {
                secondBiggest = Math.max(secondBiggest,num);
            }

            if(num < smallest){
                secondSmallest = smallest;
                smallest = num;
            } else {
                secondSmallest = Math.min(secondSmallest,num);
            }
        }

        return biggest * secondBiggest - smallest * secondSmallest;

        
    }
}

/**
 *Time complexity: O(n)
 *We iterate over nums once, performing O(1) work at each iteration.
 *Space complexity: O(1)
 *We aren't using any extra space other than a few integers.
 */
