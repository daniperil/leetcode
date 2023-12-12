'''
Problem: 1464. Maximum Product of Two Elements in an Array
Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
'''

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        biggest = 0
        second_biggest = 0
        for num in nums:
            if num > biggest:
                second_biggest = biggest
                biggest = num
            else:
                second_biggest = max(second_biggest, num)
        
        return (biggest-1)*(second_biggest-1)

'''
Time complexity: O(n)
We iterate over nums once, performing )O(1) work at each iteration.
Space complexity: O(1)
We aren't using any extra space other than a few integers.
'''
