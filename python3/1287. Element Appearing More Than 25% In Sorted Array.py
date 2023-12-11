'''
Problem: 1287. Element Appearing More Than 25% In Sorted Array
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
'''

class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        counts = defaultdict(int)
        target = len(arr)/4
        for num in arr:
            counts[num] += 1
            if counts[num] > target: 
                return num
        return -1

'''
Time complexity: O(n)O(n)O(n)

We iterate over arr once to calculate counts. This costs O(n)O(n)O(n). Next, we iterate over counts, which also costs O(n)O(n)O(n).

Space complexity: O(n)O(n)O(n)

In the worst-case scenario, counts can contain at most O(n)O(n)O(n) keys and thus grow to a size of O(n)O(n)O(n).
'''
