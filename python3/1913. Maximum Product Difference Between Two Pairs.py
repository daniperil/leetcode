'''
Problem: 1913. Maximum Product Difference Between Two Pairs
The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

Return the maximum such product difference.
'''

class Solution:
    def maxProductDifference(self, nums: List[int]) -> int:
        biggest = 0
        second_biggest = 0
        smallest = inf
        second_smallest = inf

        for num in nums:
            if num > biggest:
                second_biggest = biggest
                biggest = num
            else: 
                second_biggest = max(second_biggest, num)

            if num < smallest:
                second_smallest = smallest
                smallest = num
            else:
                second_smallest = min(second_smallest, num)
        
        return biggest * second_biggest - smallest * second_smallest

'''
Given nnn as the length of nums,

Time complexity: O(n)

We iterate over nums once, performing O(1) work at each iteration.

Space complexity: O(1)

We aren't using any extra space other than a few integers.
'''
