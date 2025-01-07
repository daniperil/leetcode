'''
Problem: 1408. String Matching in an Array
Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string
'''

class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        n = len(words)
        ans = []

        for i in range(n):
            for j in range(n):
                if i != j and words[j].find(words[i]) != -1:
                    ans.append(words[i])
                    break

        return ans
