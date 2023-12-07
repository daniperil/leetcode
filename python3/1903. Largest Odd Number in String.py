'''
Problem: 1903. Largest Odd Number in String
You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
A substring is a contiguous sequence of characters within a string.
'''

class Solution:
    def largestOddNumber(self, num: str) -> str:
      #range(starting point, ending point but not included, step value)
      #len(num)-1 is the index of the last character in the string 'num'
      for i in range(len(num) -1,-1,-1):
        if int(num[i])%2!=0:
          #num: The original string.
          #[:i+1]: The slicing syntax.
          #i+1: The ending index for the slice.
          return num[:i+1]

      return ""
        
